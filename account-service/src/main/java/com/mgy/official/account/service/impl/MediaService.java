package com.mgy.official.account.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mgy.official.account.common.enums.MediaModelEnum;
import com.mgy.official.account.common.enums.MediaTypeEnum;
import com.mgy.official.account.core.dao.MediaMapper;
import com.mgy.official.account.core.pojo.TMedia;
import com.mgy.official.account.service.IMediaService;
import com.mgy.official.account.service.req.MediaQuery;
import com.mgy.official.account.service.res.PageRes;
import com.mgy.official.account.service.res.WxMediaRes;
import com.mgy.official.account.service.utils.HttpUtils;
import com.mgy.official.account.service.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.material.WxMpMaterial;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialUploadResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.Objects;

/**
 * @author mgy
 * @date 2023/8/25
 */
@Slf4j
@Service
public class MediaService implements IMediaService {
    @Resource
    private WxMpService wxMpService;
    @Resource
    private MediaMapper mediaMapper;

    @Override
    public TMedia createTemporaryMedia(String type, String media) {
        String path = HttpUtils.download(media, System.currentTimeMillis() + "");
        String url = String.format("https://api.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%s", TokenUtils.getAccessToken(), type);
        String result = HttpUtils.doPostByFile(url, null, path, "");
        log.info("MediaService.createTemporaryMedia result={}", result);
        WxMediaRes wxMediaRes = JSON.parseObject(result, WxMediaRes.class);
        TMedia entity = new TMedia();
        entity.setGmtCreate(System.currentTimeMillis());
        entity.setMediaId(wxMediaRes.getMedia_id());
        entity.setMediaType(wxMediaRes.getType());
        entity.setOriginalUrl(media);
        entity.setMediaModel(MediaModelEnum.TEMPORARY.getCode());
        entity.setMediaUrl(String.format("https://api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s", TokenUtils.getAccessToken(), wxMediaRes.getMedia_id()));
        entity.setExpireTime(wxMediaRes.getCreated_at() + 3 * 24 * 60 * 60 * 1000);
        mediaMapper.insert(entity);
        return entity;
    }

    @Override
    public PageRes<TMedia> getTemporaryMediaList(MediaQuery mediaQuery) {
        log.info("MediaController.getTemporaryMediaList mediaQuery={}", JSON.toJSONString(mediaQuery));
        PageRes<TMedia> result = new PageRes<>();
        IPage<TMedia> page = new Page<>(mediaQuery.getPageNo(), mediaQuery.getPageSize());
        QueryWrapper<TMedia> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TMedia::getIsDeleted, 1);
        if (StringUtils.isNotBlank(mediaQuery.getMediaId())) {
            queryWrapper.lambda().eq(TMedia::getMediaId, mediaQuery.getMediaId());
        }
        if (StringUtils.isNotBlank(mediaQuery.getMediaModel())) {
            queryWrapper.lambda().eq(TMedia::getMediaModel, mediaQuery.getMediaModel());
        }
        IPage<TMedia> mediaIPage = mediaMapper.selectPage(page, queryWrapper);
        log.info("MediaController.getTemporaryMediaList mediaIPage={}", JSON.toJSONString(mediaIPage));

        result.setTotal(mediaIPage.getTotal());
        result.setItems(mediaIPage.getRecords());
        //查询数据库
        return result;
    }

    @Override
    public String getTemporaryMedia(String mediaId) {
        String url = String.format("https://api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s", TokenUtils.getAccessToken(), mediaId);
        log.info("MediaService.getTemporaryMedia url={}", url);
        return url;
    }

    @Override
    public Boolean createGraphicPicMedia(String media) {
        String path = HttpUtils.download(media, System.currentTimeMillis() + "");
        String url = String.format("https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=%s", TokenUtils.getAccessToken());
        String result = HttpUtils.doPostByFile(url, null, path, "");
        log.info("MediaService.createGraphicPicMedia result={}", result);
        JSONObject jsonObject = JSON.parseObject(result);
        TMedia entity = new TMedia();
        entity.setGmtCreate(System.currentTimeMillis());
        entity.setMediaType(MediaTypeEnum.IMAGE.getCode());
        entity.setOriginalUrl(media);
        entity.setMediaModel(MediaModelEnum.GRAPHIC_PIC.getCode());
        entity.setMediaUrl(jsonObject.getString("url"));
        mediaMapper.insert(entity);
        return Boolean.TRUE;
    }

    @Override
    public boolean deleteTemporaryMedia(String mediaId) {
        QueryWrapper<TMedia> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TMedia::getMediaId, mediaId).eq(TMedia::getIsDeleted, 1);
        TMedia tMedia = mediaMapper.selectOne(queryWrapper);
        if (Objects.isNull(tMedia)) {
            return Boolean.TRUE;
        }
        if (Objects.equals(MediaModelEnum.PERMANENT.getCode(), tMedia.getMediaModel())) {
            try {
                boolean result = wxMpService.getMaterialService().materialDelete(mediaId);
                log.info("MediaService.deleteTemporaryMedia result={}", result);
            } catch (WxErrorException e) {
                log.error("MediaService.deleteTemporaryMedia fail", e);
                return false;
            }
        }
        UpdateWrapper<TMedia> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(TMedia::getMediaId, mediaId).set(TMedia::getIsDeleted, 0);
        mediaMapper.update(null, updateWrapper);
        return Boolean.TRUE;
    }

    @Override
    public boolean createPermanentPicMedia(String type, String media) {
        String path = HttpUtils.download(media, System.currentTimeMillis() + "");
        WxMpMaterial material = new WxMpMaterial();
        material.setFile(new File(path));
        try {
            WxMpMaterialUploadResult result = wxMpService.getMaterialService().materialFileUpload(type, material);
            log.info("MediaService.createPermanentPicMedia result={}", result);
            if (StringUtils.isNotBlank(result.getMediaId())) {
                TMedia entity = new TMedia();
                entity.setGmtCreate(System.currentTimeMillis());
                entity.setMediaId(result.getMediaId());
                entity.setMediaType(type);
                entity.setOriginalUrl(media);
                entity.setMediaModel(MediaModelEnum.PERMANENT.getCode());
                entity.setMediaUrl(result.getUrl());
                mediaMapper.insert(entity);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        return false;
    }
}

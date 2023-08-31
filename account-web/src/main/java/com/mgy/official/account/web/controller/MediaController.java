package com.mgy.official.account.web.controller;

import com.alibaba.fastjson.JSON;
import com.mgy.official.account.common.enums.MediaTypeEnum;
import com.mgy.official.account.core.pojo.TMedia;
import com.mgy.official.account.service.IMediaService;
import com.mgy.official.account.service.req.MediaQuery;
import com.mgy.official.account.service.res.PageRes;
import com.mgy.official.account.web.dto.MediaDTO;
import com.mgy.official.account.web.mapper.MediaMapper;
import com.mgy.official.account.web.vo.AmisPage;
import com.mgy.official.account.web.vo.AmisResponse;
import com.mgy.official.account.web.vo.AmisResultGenerator;
import com.mgy.official.account.web.vo.TemporaryMediaVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 素材管理
 *
 * @author mgy
 * @date 2023/8/24
 */

@RestController
@Slf4j
public class MediaController {
    @Resource
    private IMediaService mediaService;

    /**
     * 新增临时素材
     *
     * @param mediaDTO
     * @return
     */
    @PostMapping("/temporary/media")
    public AmisResponse createTemporaryMedia(@RequestBody MediaDTO mediaDTO) {
        log.info("MediaController.createTemporaryMedia mediaDTO={}", JSON.toJSONString(mediaDTO));
        if (Objects.equals(MediaTypeEnum.IMAGE.getCode(), mediaDTO.getType()))
            mediaService.createTemporaryMedia(mediaDTO.getType(), mediaDTO.getMedia());
        return AmisResultGenerator.genSuccessResult();
    }

    /**
     * 查询临时素材列表
     *
     * @return
     */
    @GetMapping("/temporary/media/list")
    public AmisResponse<AmisPage<TemporaryMediaVO>> getTemporaryMediaList(String mediaId, String mediaModel, Integer pageNo, Integer pageSize) {
        if (Objects.isNull(pageNo) || pageNo < 1) {
            pageNo = 1;
        }
        if (Objects.isNull(pageSize) || pageSize < 1) {
            pageSize = 10;
        }
        MediaQuery mediaQuery = new MediaQuery();
        mediaQuery.setMediaId(mediaId);
        mediaQuery.setMediaModel(mediaModel);
        mediaQuery.setPageNo(pageNo);
        mediaQuery.setPageSize(pageSize);
        log.info("MediaController.getTemporaryMediaList mediaQuery={}", JSON.toJSONString(mediaQuery));
        PageRes<TMedia> result = mediaService.getTemporaryMediaList(mediaQuery);
        log.info("MediaController.getTemporaryMediaList result={}", JSON.toJSONString(result));
        if (Objects.isNull(result) || CollectionUtils.isEmpty(result.getItems())) {
            return AmisResultGenerator.genSuccessResult(AmisPage.empty());
        }
        List<TemporaryMediaVO> temporaryMediaVOList = MediaMapper.INSTANCE.toTemporaryMediaVOList(result.getItems());
        AmisPage<TemporaryMediaVO> amisPage = new AmisPage<>();
        amisPage.setItems(temporaryMediaVOList);
        amisPage.setTotal(result.getTotal());
        return AmisResultGenerator.genSuccessResult(amisPage);
    }

    /**
     * 获取临时素材
     *
     * @param mediaId
     * @return
     */
    @GetMapping("/temporary/media")
    public AmisResponse<String> getTemporaryMedia(String mediaId) {
        log.info("MediaController.getTemporaryMedia mediaId={}", mediaId);
        String result = mediaService.getTemporaryMedia(mediaId);
        return AmisResultGenerator.genSuccessResult(result);
    }

    /**
     * 删除临时素材
     *
     * @param mediaId
     * @return
     */
    @DeleteMapping("/temporary/media")
    public AmisResponse<Boolean> deleteTemporaryMedia(String mediaId) {
        log.info("MediaController.deleteTemporaryMedia mediaId={}", mediaId);
        boolean result = mediaService.deleteTemporaryMedia(mediaId);
        return AmisResultGenerator.genSuccessResult(result);
    }

    /**
     * 新增永久图片素材
     *
     * @param media
     * @return
     */
    @PostMapping("/graphic/media")
    public AmisResponse createGraphicPicMedia(String media) {
        log.info("MediaController.createGraphicPicMedia media={}", media);
        mediaService.createGraphicPicMedia(media);
        return AmisResultGenerator.genSuccessResult();
    }


    /**
     * 新增永久素材
     *
     * @param media
     * @return
     */
    @PostMapping("/permanent/media")
    public AmisResponse createPermanentPicMedia(String type, String media) {
        log.info("MediaController.createGraphicPicMedia media={}", media);
        mediaService.createPermanentPicMedia(type, media);
        return AmisResultGenerator.genSuccessResult();
    }

}

package com.mgy.official.account.web.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.mgy.official.account.web.vo.AmisPage;
import com.mgy.official.account.web.vo.AmisResponse;
import com.mgy.official.account.web.vo.AmisResultGenerator;
import com.mgy.official.account.web.vo.FansVO;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import me.chanjar.weixin.mp.bean.tag.WxTagListUser;
import me.chanjar.weixin.mp.bean.tag.WxUserTag;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author mgy
 * @date 2023/8/29
 */
@RestController
@Slf4j
public class FansController {
    @Resource
    private WxMpService wxMpService;

    @GetMapping("/fans/list")
    public AmisResponse<AmisPage<FansVO>> getFansList(String openId, Long tagId, Integer pageNo, Integer pageSize) throws WxErrorException {
        log.info("FansController.getFansList openId={},pageNo={},pageSize={}", openId, pageNo, pageSize);
        if (Objects.isNull(pageNo) || pageNo < 1) {
            pageNo = 1;
        }
        if (Objects.isNull(pageSize) || pageSize < 1) {
            pageSize = 10;
        }
        return Objects.isNull(tagId) ? buildUserPageResponse(openId, pageNo, pageSize) : buildUserTagPageResponse(openId, tagId, pageNo, pageSize);
    }

    private AmisResponse<AmisPage<FansVO>> buildUserPageResponse(String openId, Integer pageNo, Integer pageSize) throws WxErrorException {
        AmisPage<FansVO> amisPage = new AmisPage<>();
        WxMpUserList wxMpUserList = wxMpService.getUserService().userList();
        log.info("FansController.getFansList wxMpUserList={}", JSON.toJSONString(wxMpUserList));
        if (CollectionUtils.isNotEmpty(wxMpUserList.getOpenids())) {
            List<FansVO> fansVOList = new ArrayList<>();
            List<String> openids = wxMpUserList.getOpenids();
            for (int i = 0; i < openids.size(); i++) {
                FansVO fansVO = new FansVO();
                fansVO.setId(i + 1);
                fansVO.setOpenId(openids.get(i));
                fansVOList.add(fansVO);
            }
            List<FansVO> fansList;
            if (StringUtils.isNotBlank(openId)) {
                FansVO fansVO = fansVOList.stream().filter(a -> Objects.equals(a.getOpenId(), openId)).findAny().orElse(null);
                if (Objects.nonNull(fansVO)) {
                    amisPage.setTotal(1L);
                    fansList = Lists.newArrayList(fansVO);
                } else {
                    return AmisResultGenerator.genSuccessResult(AmisPage.empty());
                }
            } else {
                amisPage.setTotal((long) wxMpUserList.getOpenids().size());
                List<List<FansVO>> partition = Lists.partition(fansVOList, pageSize);
                if (pageNo > partition.size()) {
                    fansList = partition.get(partition.size() - 1);
                } else {
                    fansList = partition.get(pageNo - 1);
                }
            }
            addUserTag(fansList);
            amisPage.setItems(fansList);
            return AmisResultGenerator.genSuccessResult(amisPage);
        }
        return AmisResultGenerator.genSuccessResult(AmisPage.empty());
    }

    private void addUserTag(List<FansVO> fansList) throws WxErrorException {
        List<WxUserTag> wxUserTags = wxMpService.getUserTagService().tagGet();
        for (FansVO fansVO : fansList) {
            try {
                List<Long> tagList = wxMpService.getUserTagService().userTagList(fansVO.getOpenId());
                if (CollectionUtils.isNotEmpty(tagList)) {
                    String joinTags = wxUserTags.stream().filter(tag -> tagList.contains(tag.getId())).map(WxUserTag::getName).collect(Collectors.joining("/"));
                    fansVO.setTags(joinTags);
                }
            } catch (WxErrorException e) {
                log.info("FansController.getFansList queryUserTagList fail openId={}", fansVO.getOpenId());
            }
        }
    }

    private AmisResponse<AmisPage<FansVO>> buildUserTagPageResponse(String openId, Long tagId, Integer pageNo, Integer pageSize) throws WxErrorException {
        WxTagListUser wxMpUserList = userList(tagId, null);
        log.info("FansController.buildUserTagPageResponse wxMpUserList={}", JSON.toJSONString(wxMpUserList));
        WxMpUserList mergeList = new WxMpUserList();
        mergeList.getOpenids().addAll(wxMpUserList.getData().getOpenidList());
        mergeList.setCount(wxMpUserList.getCount());

        while (StringUtils.isNotEmpty(wxMpUserList.getNextOpenid())) {
            WxTagListUser nextReqUserList = userList(tagId, wxMpUserList.getNextOpenid());
            log.info("FansController.buildUserTagPageResponse nextReqUserList={}", JSON.toJSONString(nextReqUserList));
            if (Objects.isNull(nextReqUserList) || Objects.isNull(nextReqUserList.getData()) || CollectionUtils.isEmpty(nextReqUserList.getData().getOpenidList())) {
                break;
            }
            mergeList.getOpenids().addAll(nextReqUserList.getData().getOpenidList());
            mergeList.setCount(mergeList.getCount() + nextReqUserList.getCount());
            wxMpUserList = nextReqUserList;
        }
        mergeList.setTotal(mergeList.getOpenids().size());
        log.info("FansController.getFansTagList mergeList={}", JSON.toJSONString(mergeList));

        List<String> openids = mergeList.getOpenids();
        if (CollectionUtils.isEmpty(openids)) {
            return AmisResultGenerator.genSuccessResult(AmisPage.empty());
        }
        AmisPage<FansVO> amisPage = new AmisPage<>();
        List<FansVO> fansList;
        if (CollectionUtils.isNotEmpty(openids)) {
            List<FansVO> fansVOList = new ArrayList<>();
            for (int i = 0; i < openids.size(); i++) {
                FansVO fansVO = new FansVO();
                fansVO.setId(i + 1);
                fansVO.setOpenId(openids.get(i));
                fansVOList.add(fansVO);
            }
            if (StringUtils.isNotBlank(openId)) {
                FansVO fansVO = fansVOList.stream().filter(a -> Objects.equals(a.getOpenId(), openId)).findAny().orElse(null);
                if (Objects.nonNull(fansVO)) {
                    amisPage.setTotal(1L);
                    fansList = Lists.newArrayList(fansVO);
                } else {
                    return AmisResultGenerator.genSuccessResult(AmisPage.empty());
                }
            } else {
                amisPage.setTotal(mergeList.getTotal());
                List<List<FansVO>> partition = Lists.partition(fansVOList, pageSize);
                if (pageNo > partition.size()) {
                    fansList = partition.get(partition.size() - 1);
                } else {
                    fansList = partition.get(pageNo - 1);
                }
            }
            addUserTag(fansList);
            amisPage.setItems(fansList);
            log.info("FansController.getFansTagList amisPage={}", JSON.toJSONString(amisPage));
            return AmisResultGenerator.genSuccessResult(amisPage);
        }
        return AmisResultGenerator.genSuccessResult(AmisPage.empty());
    }

    public WxTagListUser userList(Long tagId, String nextOpenid) throws WxErrorException {
        return wxMpService.getUserTagService().tagListUser(tagId, nextOpenid);
    }
}

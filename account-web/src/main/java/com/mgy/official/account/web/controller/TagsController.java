package com.mgy.official.account.web.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.mgy.official.account.web.dto.TagAddFansDTO;
import com.mgy.official.account.web.dto.TagRemoveFansDTO;
import com.mgy.official.account.web.mapper.TagMapper;
import com.mgy.official.account.web.vo.*;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.tag.WxUserTag;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author mgy
 * @date 2023/8/29
 */
@RestController
@Slf4j
public class TagsController {
    @Resource
    private WxMpService wxMpService;

    @PostMapping("/tag")
    public AmisResponse createTag(String name) throws WxErrorException {
        log.info("TagsController.createTag name={}", name);
        WxUserTag wxUserTag = wxMpService.getUserTagService().tagCreate(name);

        return AmisResultGenerator.genSuccessResult();
    }

    @GetMapping("/tags")
    public AmisResponse<AmisPage<WxUserTagVO>> getTagsList(Long tagId, Integer pageNo, Integer pageSize) {
        if (Objects.isNull(pageNo) || pageNo < 1) {
            pageNo = 1;
        }
        if (Objects.isNull(pageSize) || pageSize < 1) {
            pageSize = 10;
        }
        AmisPage<WxUserTagVO> amisPage = new AmisPage<>();
        try {
            List<WxUserTag> wxUserTags = wxMpService.getUserTagService().tagGet();
            log.info("TagsController.getTagsList wxUserTags={}", JSON.toJSONString(wxUserTags));
            if (CollectionUtils.isNotEmpty(wxUserTags)) {
                List<WxUserTag> wxUserTagList;
                if (Objects.nonNull(tagId)) {
                    WxUserTag wxUserTag = wxUserTags.stream().filter(a -> Objects.equals(a.getId(), tagId)).findAny().orElse(null);
                    if (Objects.nonNull(wxUserTag)) {
                        amisPage.setTotal(1L);
                        wxUserTagList = Lists.newArrayList(wxUserTag);
                    } else {
                        return AmisResultGenerator.genSuccessResult(AmisPage.empty());
                    }
                } else {
                    amisPage.setTotal((long) wxUserTags.size());
                    List<List<WxUserTag>> partition = Lists.partition(wxUserTags, pageSize);
                    if (pageNo > partition.size()) {
                        wxUserTagList = partition.get(partition.size() - 1);
                    } else {
                        wxUserTagList = partition.get(pageNo - 1);
                    }
                }
                List<WxUserTagVO> wxUserTagVOList = TagMapper.INSTANCE.toWxUserTagVOList(wxUserTagList);
                amisPage.setItems(wxUserTagVOList);
                return AmisResultGenerator.genSuccessResult(amisPage);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return AmisResultGenerator.genSuccessResult(AmisPage.empty());
    }

    @GetMapping("/tags/all")
    public AmisResponse<OptionsWithoutChildVO> getTagsAll() {
        AmisResponse<AmisPage<WxUserTagVO>> tagsList = getTagsList(null, 1, 1000);
        log.info("TagsController.getTagsAll tagsList={}", JSON.toJSONString(tagsList));
        if (Objects.isNull(tagsList) || Objects.isNull(tagsList.getData()) || CollectionUtils.isEmpty(tagsList.getData().getItems())) {
            return AmisResultGenerator.genSuccessResult();
        }
        List<OptionWithoutChildVO> optionWithoutChildVOS = tagsList.getData().getItems().stream().map(tag -> {
            OptionWithoutChildVO option = new OptionWithoutChildVO();
            option.setLabel(tag.getName());
            option.setValue(String.valueOf(tag.getTagId()));
            return option;
        }).collect(Collectors.toList());
        OptionsWithoutChildVO optionsWithoutChildVO = new OptionsWithoutChildVO();
        optionsWithoutChildVO.setValue("");
        optionsWithoutChildVO.setOptions(optionWithoutChildVOS);
        log.info("TagsController.getTagsAll optionsWithoutChildVO={}", JSON.toJSONString(optionsWithoutChildVO));
        return AmisResultGenerator.genSuccessResult(optionsWithoutChildVO);
    }

    @PutMapping("/tag")
    public AmisResponse<Boolean> modifyTag(Long tagId, String name) throws WxErrorException {
        log.info("TagsController.modifyTag tagId={},name={}", tagId, name);
        Boolean result = wxMpService.getUserTagService().tagUpdate(tagId, name);
        log.info("TagsController.modifyTag result={}", result);
        return AmisResultGenerator.genSuccessResult(result);
    }

    @DeleteMapping("/tag")
    public AmisResponse<Boolean> deleteTag(Long tagId) throws WxErrorException {
        log.info("TagsController.deleteTag tagId={}", tagId);
        Boolean result = wxMpService.getUserTagService().tagDelete(tagId);
        log.info("TagsController.deleteTag result={}", result);
        return AmisResultGenerator.genSuccessResult(result);
    }

    @PostMapping("/tag/add/fans")
    public AmisResponse<Boolean> tagFans(@RequestBody TagAddFansDTO tagAddFansDTO) throws WxErrorException {
        log.info("TagsController.tagFans tagAddFansDTO={}", JSON.toJSONString(tagAddFansDTO));
        Boolean result = wxMpService.getUserTagService().batchTagging(tagAddFansDTO.getTagId(), tagAddFansDTO.getIds().split(","));
        log.info("TagsController.tagFans result={}", result);
        return AmisResultGenerator.genSuccessResult(result);
    }

    @PostMapping("/tag/remove/fans")
    public AmisResponse<Boolean> tagRemoveFans(@RequestBody TagRemoveFansDTO tagRemoveFansDTO) throws WxErrorException {
        log.info("TagsController.tagRemoveFans tagRemoveFansDTO={}", JSON.toJSONString(tagRemoveFansDTO));
        Boolean result = wxMpService.getUserTagService().batchUntagging(tagRemoveFansDTO.getTagId(), tagRemoveFansDTO.getIds().split(","));
        log.info("TagsController.tagRemoveFans result={}", result);
        return AmisResultGenerator.genSuccessResult(result);
    }


}

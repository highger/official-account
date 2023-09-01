package com.mgy.official.account.web.controller;

import com.alibaba.fastjson.JSON;
import com.mgy.official.account.web.dto.MediaDTO;
import com.mgy.official.account.web.vo.AmisResponse;
import com.mgy.official.account.web.vo.AmisResultGenerator;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.draft.WxMpAddDraft;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 草稿箱
 * @author mgy
 * @date 2023/8/31
 */
@RestController
@Slf4j
public class DraftController {
    @Resource
    private WxMpService wxMpService;

    @PostMapping("/article")
    public AmisResponse createTemporaryMedia(@RequestBody MediaDTO mediaDTO) throws WxErrorException {
        log.info("MediaController.createTemporaryMedia mediaDTO={}", JSON.toJSONString(mediaDTO));

        WxMpAddDraft wxMpAddDraft = null;
        String s = wxMpService.getDraftService().addDraft(wxMpAddDraft);

        return AmisResultGenerator.genSuccessResult();
    }
}

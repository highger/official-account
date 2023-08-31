package com.mgy.official.account.service.impl;

import com.alibaba.fastjson.JSON;
import com.mgy.official.account.service.IIndustryService;
import com.mgy.official.account.service.req.IndustryReq;
import com.mgy.official.account.service.res.IndustryRes;
import com.mgy.official.account.service.utils.HttpUtils;
import com.mgy.official.account.service.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author mgy
 * @date 2023/8/25
 */
@Service
@Slf4j
public class IndustryService implements IIndustryService {

    @Value("${system.open}")
    private Boolean systemOpen;

    /**
     * {
     * "industry_id1":"1",
     * "industry_id2":"4"
     * }
     */
    @Override
    public Boolean addIndustry(IndustryReq industryReq) {
        if (!systemOpen) {
            return Boolean.TRUE;
        }
        String url = String.format("https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=%s", TokenUtils.getAccessToken());
        String addResult = HttpUtils.doPost(url, JSON.toJSONString(industryReq));
        log.info("IndustryService.addIndustry addResult={}", addResult);
        return Boolean.TRUE;
    }

    @Override
    public IndustryRes getIndustry() {
        if (!systemOpen) {
            return null;
        }
        String url = String.format("https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=%s", TokenUtils.getAccessToken());
        log.info("IndustryService.getIndustry url={}", url);
        String getResult = HttpUtils.doGet(url);
        log.info("IndustryService.getIndustry getResult={}", getResult);
        if (StringUtils.isBlank(getResult)) {
            return null;
        }
        return JSON.parseObject(getResult, IndustryRes.class);
    }
}

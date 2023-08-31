package com.mgy.official.account.web.controller;

import com.alibaba.fastjson.JSON;
import com.mgy.official.account.service.IIndustryService;
import com.mgy.official.account.service.req.IndustryReq;
import com.mgy.official.account.service.res.IndustryRes;
import com.mgy.official.account.web.vo.AmisPage;
import com.mgy.official.account.web.vo.AmisResponse;
import com.mgy.official.account.web.vo.AmisResultGenerator;
import com.mgy.official.account.web.vo.IndustryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author mgy
 * @date 2023/8/25
 */
@RestController
@Slf4j
public class IndustryController {
    @Resource
    private IIndustryService industryService;

    @PostMapping("/industry")
    public AmisResponse createIndustry(String primaryIndustry, String secondaryIndustry) {
        IndustryReq industryReq = new IndustryReq();
        industryReq.setPrimaryIndustry(primaryIndustry);
        industryReq.setSecondaryIndustry(secondaryIndustry);
        log.info("IndustryController.createIndustry industry={}", JSON.toJSONString(industryReq));
        industryService.addIndustry(industryReq);
        return AmisResultGenerator.genSuccessResult();
    }

    @GetMapping("/industry")
    public AmisResponse<AmisPage<IndustryVO>> getIndustry() {
        log.info("IndustryController.getIndustry init");
        IndustryRes industry = industryService.getIndustry();
        if (Objects.isNull(industry)) {
            return AmisResultGenerator.genSuccessResult(AmisPage.empty());
        }
        IndustryVO industryVO = new IndustryVO();
        industryVO.setPrimaryIndustry(industry.getPrimary_industry().getFirst_class() + " " + industry.getPrimary_industry().getSecond_class());
        industryVO.setSecondaryIndustry(industry.getSecondary_industry().getFirst_class() + " " + industry.getSecondary_industry().getSecond_class());
        log.info("IndustryController.getIndustry industryVO={}", JSON.toJSONString(industryVO));
        return AmisResultGenerator.genSuccessResult(new AmisPage<>(List.of(industryVO), 1L));
    }

}

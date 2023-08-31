package com.mgy.official.account.service;

import com.mgy.official.account.service.req.IndustryReq;
import com.mgy.official.account.service.res.IndustryRes;

/**
 * @author mgy
 * @date 2023/8/25
 */
public interface IIndustryService {
    Boolean addIndustry(IndustryReq industryReq);

    IndustryRes getIndustry();
}

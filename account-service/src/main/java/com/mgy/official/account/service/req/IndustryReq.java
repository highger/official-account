package com.mgy.official.account.service.req;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author mgy
 * @date 2023/8/25
 */
@Data
public class IndustryReq {
    @JSONField(name = "industry_id1")
    private String primaryIndustry;
    @JSONField(name = "industry_id2")
    private String secondaryIndustry;
}

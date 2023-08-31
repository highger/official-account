package com.mgy.official.account.service.res;

import lombok.Data;

/**
 * @author mgy
 * @date 2023/8/25
 */
@Data
public class IndustryRes {
    private IndustryItemRes primary_industry;
    private IndustryItemRes secondary_industry;
}

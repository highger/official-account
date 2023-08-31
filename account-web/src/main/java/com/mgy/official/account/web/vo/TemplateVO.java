package com.mgy.official.account.web.vo;

import lombok.Data;

/**
 * @author mgy
 * @date 2023/8/25
 */
@Data
public class TemplateVO {
    private String templateId;
    private String title;
    private String primaryIndustry;
    private String deputyIndustry;
    private String content;
    private String example;
}

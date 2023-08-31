package com.mgy.official.account.service.res;

import lombok.Data;

/**
 * @author mgy
 * @date 2023/8/25
 */
@Data
public class TemplateRes {
    private String template_id;
    private String title;
    private String primary_industry;
    private String deputy_industry;
    private String content;
    private String example;
}

package com.mgy.official.account.service.model;

import lombok.Data;

/**
 * @author mgy
 * @date 2023/8/24
 */
@Data
public class TemplateMessage {

    private String touser;
    private String template_id;
    private Object data;

}

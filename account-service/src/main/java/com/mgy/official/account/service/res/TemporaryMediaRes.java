package com.mgy.official.account.service.res;

import lombok.Data;

/**
 * @author mgy
 * @date 2023/8/25
 */
@Data
public class TemporaryMediaRes {
    private String id;
    private String mediaId;
    private String mediaType;
    private Long gmtCreate;
    private Long expireTime;//创建时间+3天
    private String expireType;
}

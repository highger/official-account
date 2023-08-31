package com.mgy.official.account.web.vo;

import lombok.Data;

/**
 * @author mgy
 * @date 2023/8/25
 */
@Data
public class TemporaryMediaVO {
    private Integer id;
    private String mediaModel;
    private String mediaUrl;
    private String originalUrl;
    private String mediaType;
    private String mediaId;
    private String thumbMediaId;
    private Long expireTime;//创建时间+3天
    private Integer isDeleted;
    private Long gmtCreate;

}

package com.mgy.official.account.web.vo;

import lombok.Data;

/**
 * @author mgy
 * @date 2023/8/30
 */
@Data
public class WxUserTagVO {
    /**
     * 标签id，由微信分配.
     */
    private Long tagId;

    /**
     * 标签名，UTF8编码.
     */
    private String name;

    /**
     * 此标签下粉丝数.
     */
    private Integer count;
}

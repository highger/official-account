package com.mgy.official.account.core.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author mgy
 * @date 2023/8/29
 */
@Data
@TableName(value = "t_media")
public class TMedia {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String mediaModel;
    private String mediaUrl;
    private String originalUrl;
    private String mediaType;
    private String mediaId;
    private String thumbMediaId;
    private Long expireTime;//创建时间+3天
    private Integer isDeleted;
    private Long gmtModified;
    private Long gmtCreate;
}
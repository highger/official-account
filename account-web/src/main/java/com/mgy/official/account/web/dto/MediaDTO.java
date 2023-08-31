package com.mgy.official.account.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author mgy
 * @date 2023/8/25
 */
@Data
public class MediaDTO implements Serializable {
    //媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
    private String type;
    private String media;
}

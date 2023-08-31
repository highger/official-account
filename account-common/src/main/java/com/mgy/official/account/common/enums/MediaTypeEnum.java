package com.mgy.official.account.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author mgy
 * @date 2023/8/23
 */
@Getter
@AllArgsConstructor
public enum MediaTypeEnum {

    IMAGE("image", "图片", "10M", "支持bmp/png/jpeg/jpg/gif格式"),
    VOICE("voice", "语音", "2M", "播放长度不超过60s，支持mp3/wma/wav/amr格式"),
    VIDEO("video", "视频", "10M", "支持MP4格式"),
    THUMB("thumb", "缩略图", "64KB", "支持JPG格式");

    private String code;

    private String msg;

    private String limit;

    private String desc;
}

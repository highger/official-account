package com.mgy.official.account.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author mgy
 * @date 2023/8/23
 */
@Getter
@AllArgsConstructor
public enum MediaModelEnum {

    TEMPORARY("TEMPORARY", "临时素材"),
    PERMANENT("PERMANENT", "永久素材"),
    GRAPHIC_PIC("GRAPHIC_PIC", "图文消息内的图片永久素材");

    private String code;

    private String desc;
}

package com.mgy.official.account.service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author mgyQR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值
 * @date 2023/8/28
 */
@Getter
@AllArgsConstructor
public enum QrSceneTypeEnum {
    QR_SCENE("QR_SCENE", "临时的整型参数值"),
    QR_STR_SCENE("QR_STR_SCENE", "临时的字符串参数值"),
    QR_LIMIT_SCENE("QR_LIMIT_SCENE", "永久的整型参数值"),
    QR_LIMIT_STR_SCENE("QR_LIMIT_STR_SCENE", "永久的字符串参数值");

    private String code;

    private String desc;
}

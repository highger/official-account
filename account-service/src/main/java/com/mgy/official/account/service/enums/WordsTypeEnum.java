package com.mgy.official.account.service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author mgy
 * @date 2023/8/23
 */
@Getter
@AllArgsConstructor
public enum WordsTypeEnum {
    JIN("1", "近义词"),
    FAN("2", "反义词");

    private String code;

    private String msg;

    public static WordsTypeEnum getWordsTypeEnum(String code) {
       return Arrays.stream(WordsTypeEnum.values()).filter(e-> Objects.equals(e.code,code)).findAny().orElse(null);
    }
}

package com.mgy.official.account.web.vo;

/**
 * 响应结果生成工具
 */
public class AmisResultGenerator {
    private AmisResultGenerator() {
    }

    public static <T> AmisResponse<T> genSuccessResult() {
        return AmisResponse.success();
    }

    public static <T> AmisResponse<T> genSuccessResult(T data) {
        return AmisResponse.success(data);
    }

    public static <T> AmisResponse<T> genFailResult(String msg) {
        return AmisResponse.fail(msg);
    }

}
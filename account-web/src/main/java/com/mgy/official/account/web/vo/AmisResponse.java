package com.mgy.official.account.web.vo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: Amis请求统一返回类
 **/
@Data
@Slf4j
public class AmisResponse<T> {

    private static final long serialVersionUID = 5843754594225568199L;

    /**
     * 请求状态 0为请求成功
     *
     * @mock true
     * @since 1.0
     */
    private Integer status;

    /**
     * 请求失败返回的信息，成功则返回空值
     *
     * @mock
     * @since 1.0
     */
    private String msg;

    /**
     * 获取结果
     *
     * @mock 返回的数据 以键值对的方式
     * @since 1.0
     */
    private T data;

    /**
     * 时间戳
     */
    private Long t;

    private AmisResponse() {
    }

    private AmisResponse(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.t = System.currentTimeMillis();
    }

    public static <T> AmisResponse<T> success() {
        return success(null);
    }

    public static <T> AmisResponse<T> success(T data) {
        return newInstance(0, "", data);
    }

    public static <T> AmisResponse<T> fail(String msg) {
        return fail(500, msg);
    }

    public static <T> AmisResponse<T> fail(Integer status, String msg) {
        AmisResponse<T> res = newInstance(status, msg, null);
        log.warn("response#fail. res={}", res);
        return res;
    }

    private static <T> AmisResponse<T> newInstance(Integer status, String msg, T data) {
        return new AmisResponse<>(status, msg, data);
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", t=" + t +
                '}';
    }
}

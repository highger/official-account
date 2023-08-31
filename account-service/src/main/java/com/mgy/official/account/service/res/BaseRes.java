package com.mgy.official.account.service.res;

import lombok.Data;

import java.util.Objects;

/**
 * @author mgy
 * @date 2023/8/25
 */
@Data
public class BaseRes {

    private String errmsg;

    private Integer errcode;

    public boolean isSuccess() {
        return Objects.equals(0, this.errcode);
    }

}

package com.mgy.official.account.service.model;

/**
 * @author mgy
 * @date 2023/8/23
 */

public class AccessToken {
    private String token;
    private Long expireTime;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireIn) {
        this.expireTime = System.currentTimeMillis() + expireIn;
    }

    public boolean isExpire() {
        return System.currentTimeMillis() > expireTime;
    }
}

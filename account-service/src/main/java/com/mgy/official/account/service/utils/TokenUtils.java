package com.mgy.official.account.service.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mgy.official.account.service.model.AccessToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author mgy
 * @date 2023/8/23
 */
@Slf4j
@Component
public class TokenUtils {
    private static final String GET_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    private static String appId = "wxb4222e21418329ab";
    private static String secret = "4c69da3d7470781e14a0f3d7e06927ec";
    private static AccessToken accessToken = new AccessToken();

    public static void main(String[] args) {
        System.out.println(getAccessToken());
        System.out.println(getAccessToken());
    }

    public static String getToken() {
        String url = String.format(GET_TOKEN, appId, secret);
        String token = JuheUtils.doGet(url);
        log.info("getToken token={}", token);
        JSONObject jsonObject = JSON.parseObject(token);
        String getToken = jsonObject.getString("access_token");
        long expiresIn = jsonObject.getLong("expires_in");
        accessToken.setToken(getToken);
        accessToken.setExpireTime(expiresIn);
        return token;
    }

    public static String getAccessToken() {
        if (Objects.isNull(accessToken.getExpireTime()) || accessToken.isExpire()) {
            getToken();
        }
        return accessToken.getToken();

    }

}

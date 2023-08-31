package com.mgy.official.account.service.config;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class WxMpServiceConfiguration {
    @Value("${wechat.open.appId}")
    private String appId;
    @Value("${wechat.open.secret}")
    private String secret;
    @Value("${wechat.open.token}")
    private String token;
    @Value("${wechat.open.aesKey}")
    private String aesKey;

    @Bean
    public WxMpDefaultConfigImpl accountWxMpDefaultConfigImpl() {
        WxMpDefaultConfigImpl wxMpDefaultConfigImpl = new WxMpDefaultConfigImpl();
        wxMpDefaultConfigImpl.setAppId(appId);
        wxMpDefaultConfigImpl.setSecret(secret);
        wxMpDefaultConfigImpl.setToken(token);
        wxMpDefaultConfigImpl.setAesKey(aesKey);
        return wxMpDefaultConfigImpl;
    }

    /**
     * @param accountWxMpDefaultConfigImpl
     * @return
     */
    @Bean
    public WxMpService wxMpService(WxMpDefaultConfigImpl accountWxMpDefaultConfigImpl) {
        WxMpService wxService = new WxMpServiceImpl();
        wxService.setWxMpConfigStorage(accountWxMpDefaultConfigImpl);
        return wxService;
    }

}

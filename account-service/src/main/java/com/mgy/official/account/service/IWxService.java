package com.mgy.official.account.service;

/**
 * @author mgy
 * @date 2023/8/28
 */
public interface IWxService {
    String getSignUpUserInfo(String code);

    String getRankingList();
}

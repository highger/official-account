package com.mgy.official.account.service.res;

import lombok.Data;

/**
 * @author mgy
 * @date 2023/8/28
 */
@Data
public class SubscribedUser {
    private String openid;
    private String nickname;
    private int sex;
    private String city;
    private String province;
    private String headimgurl;
}

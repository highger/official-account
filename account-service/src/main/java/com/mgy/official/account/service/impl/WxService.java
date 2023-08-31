package com.mgy.official.account.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mgy.official.account.core.dao.FollowInfoMapper;
import com.mgy.official.account.core.dao.UserMapper;
import com.mgy.official.account.core.model.RankingItem;
import com.mgy.official.account.core.pojo.TUser;
import com.mgy.official.account.service.IWxService;
import com.mgy.official.account.service.res.SubscribedUser;
import com.mgy.official.account.service.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mgy
 * @date 2023/8/28
 */
@Service
@Slf4j
public class WxService implements IWxService {
    @Value("${wechat.open.appId}")
    private String appId;
    @Value("${wechat.open.secret}")
    private String secret;
    @Resource
    private UserMapper userMapper;
    @Resource
    private FollowInfoMapper followInfoMapper;

    @Override
    public String getSignUpUserInfo(String code) {
        //根据code获取Access._token的地址
        String url = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code",
                appId,
                secret,
                code);
        //发送get请求获得access_token
        String result = HttpUtils.doGet(url);
        String accessToken = JSONObject.parseObject(result).getString("access_token");
        String openId = JSONObject.parseObject(result).getString("openid");
        String userInfoUrl = String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN",
                accessToken,
                openId);
        //拉取用户信息
        String userInfo = HttpUtils.doGet(userInfoUrl); //解析获得微信号、昵称、头像
        SubscribedUser user = JSONObject.parseObject(userInfo, SubscribedUser.class); //存入微信号昵称对应表
        TUser tUser = new TUser();
        BeanUtils.copyProperties(user, tUser);
        tUser.setHeadImgUrl(user.getHeadimgurl());
        tUser.setNickName(user.getNickname());
        tUser.setOpenId(user.getOpenid());
        userMapper.insert(tUser);
//        String html= getSignUpHtml();
//        return "html";
        return "报名成功，你可以回复\"海报\"生成自己的邀请码。也可以回复\"排行榜\"查看最新榜单。";
    }

    /**
     * 生成排行榜
     * return 带table的htmL
     */

    public String getRankingList() {
        List<RankingItem> rankingList = followInfoMapper.selectRankingList();
        String html = createHtml(rankingList);
        return html;
    }

    private String createHtml(List<RankingItem> rankingList) {
        if (CollectionUtils.isEmpty(rankingList)) {
            return Strings.EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        rankingList.forEach(ranking -> {
            sb.append(ranking.getNickName()).append(" ").append(ranking.getCount()).append("\n");
        });
        return sb.toString();
    }
}

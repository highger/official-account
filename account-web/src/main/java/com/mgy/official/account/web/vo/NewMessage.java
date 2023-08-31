package com.mgy.official.account.web.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author mgy
 * @date 2023/8/23
 */
@Data
@XStreamAlias("xml")
public class NewMessage implements Serializable {
    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private long createTime;
    @XStreamAlias("MsgType")
    private String msgType;
    @XStreamAlias("ArticleCount")
    private int articleCount;
    @XStreamAlias("Articles")
    private List<Article> articles;
}
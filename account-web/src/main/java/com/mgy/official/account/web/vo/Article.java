package com.mgy.official.account.web.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.io.Serializable;

/**
 * @author mgy
 * @date 2023/8/23
 */
@Data
@XStreamAlias("item")
public class Article implements Serializable {
    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Description")
    private String description;
    @XStreamAlias("PicUrl")
    private String picUrl;
    @XStreamAlias("Url")
    private String url;
}

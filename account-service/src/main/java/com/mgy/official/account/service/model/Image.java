package com.mgy.official.account.service.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author mgy
 * @date 2023/8/28
 */
@Data
@AllArgsConstructor
@XStreamAlias("Image")
public class Image {
    @XStreamAlias("MediaId")
    private String mediaId;
}

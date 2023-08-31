package com.mgy.official.account.service;

import com.mgy.official.account.core.pojo.TMedia;
import com.mgy.official.account.service.req.MediaQuery;
import com.mgy.official.account.service.res.PageRes;
import com.mgy.official.account.service.res.TemporaryMediaRes;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;

/**
 * @author mgy
 * @date 2023/8/25
 */
public interface IMediaService {
    TMedia createTemporaryMedia(String type, String media);

    PageRes<TMedia> getTemporaryMediaList(MediaQuery mediaQuery);

    String getTemporaryMedia(String mediaId);

    Boolean createGraphicPicMedia(String media);

    boolean deleteTemporaryMedia(String mediaId);

    boolean createPermanentPicMedia(String type, String media);
}

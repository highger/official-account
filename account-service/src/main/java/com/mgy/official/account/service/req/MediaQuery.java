package com.mgy.official.account.service.req;

import com.mgy.official.account.core.model.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author mgy
 * @date 2023/8/29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MediaQuery extends PageQuery {
    private  String mediaId;
    private  String mediaModel;
}

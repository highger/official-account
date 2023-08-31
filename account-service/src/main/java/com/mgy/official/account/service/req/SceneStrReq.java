package com.mgy.official.account.service.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author mgy
 * @date 2023/8/28
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SceneStrReq extends SceneReq{
    private String scene_str;
}

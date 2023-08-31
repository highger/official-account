package com.mgy.official.account.service.req;

import lombok.Data;

/**
 * {"expire_seconds": 604800, "action_name": "QR_SCENE", "action_info": {"scene": {"scene_id": 123}}}
 *
 * @author mgy
 * @date 2023/8/28
 */
@Data
public class QrCodeReq {
    private Integer expire_seconds;
    private String action_name;
    private ActionInfoReq action_info;
}

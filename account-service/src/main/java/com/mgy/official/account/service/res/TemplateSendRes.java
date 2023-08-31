package com.mgy.official.account.service.res;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author mgy
 * @date 2023/8/25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TemplateSendRes extends BaseRes{
    private Long msgid;
}

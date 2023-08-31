package com.mgy.official.account.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mgy
 * @date 2023/8/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FansVO {
    private Integer id;
    private String openId;
    private String tags;
}

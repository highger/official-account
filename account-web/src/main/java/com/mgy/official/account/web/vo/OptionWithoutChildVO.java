package com.mgy.official.account.web.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: micro-oem-saas
 * @description:
 * @author: milong
 * @create: 2021-10-30 16:51
 **/
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class OptionWithoutChildVO {

    private String label;

    private String value;

}

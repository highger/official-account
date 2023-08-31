package com.mgy.official.account.web.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: micro-oem-saas
 * @description:
 * @author: milong
 * @create: 2021-10-30 16:52
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OptionsWithoutChildVO {

    String value;

    List<OptionWithoutChildVO> options;
}

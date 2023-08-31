package com.mgy.official.account.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author mgy
 * @date 2023/8/23
 */
@Data
public class UpdateTestDTO implements Serializable {
    private String uid;
    private String name;
    private Integer age;
}

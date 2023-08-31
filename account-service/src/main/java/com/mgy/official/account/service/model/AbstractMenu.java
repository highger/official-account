package com.mgy.official.account.service.model;

import lombok.Data;

/**
 * @author mgy
 * @date 2023/8/24
 */
@Data
public abstract class AbstractMenu {

    private String name;

    protected AbstractMenu(String name) {
        this.name = name;
    }
}
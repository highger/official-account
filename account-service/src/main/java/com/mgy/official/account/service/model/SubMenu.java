package com.mgy.official.account.service.model;

import java.util.List;

/**
 * @author mgy
 * @date 2023/8/24
 */
public class SubMenu extends AbstractMenu {
    public SubMenu(String name) {
        super(name);
    }

    private List<AbstractMenu> sub_button;

    public List<AbstractMenu> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<AbstractMenu> sub_button) {
        this.sub_button = sub_button;
    }
}

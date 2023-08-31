package com.mgy.official.account.service.model;


/**
 * @author mgy
 * @date 2023/8/24
 */
public class ViewMenu extends AbstractMenu {
    public ViewMenu(String name, String url) {
        super(name);
        this.type = "view";
        this.url = url;
    }

    private String type;
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

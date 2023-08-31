package com.mgy.official.account.service.model;


/**
 * @author mgy
 * @date 2023/8/24
 */
public class PhotoPrAlbumMenu extends AbstractMenu {
    public PhotoPrAlbumMenu(String name, String key) {
        super(name);
        this.type = "pic_photo_or_album";
        this.key = key;
    }

    private String type;
    private String key;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

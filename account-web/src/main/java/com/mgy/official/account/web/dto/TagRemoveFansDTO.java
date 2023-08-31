package com.mgy.official.account.web.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author mgy
 * @date 2023/8/25
 */
@Data
public class TagRemoveFansDTO implements Serializable {
    private Long tagId;
    private String ids;
}

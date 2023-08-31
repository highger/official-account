package com.mgy.official.account.core.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author mgy
 * @date 2023/8/28
 */
@Data
@TableName(value = "t_user")
public class TUser {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String openId;
    private String nickName;
    private int sex;
    private String city;
    private String province;
    private String headImgUrl;
}

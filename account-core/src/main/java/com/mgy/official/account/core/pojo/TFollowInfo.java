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
@TableName(value = "t_follow_info")
public class TFollowInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String openId;
    private String followOpenId;
    private Long followTime;
    private Long gmtCreate;
}
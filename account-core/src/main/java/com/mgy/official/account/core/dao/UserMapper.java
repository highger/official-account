package com.mgy.official.account.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mgy.official.account.core.pojo.TUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author mgy
 * @date 2023/8/27
 */
@Mapper
public interface UserMapper extends BaseMapper<TUser> {

}

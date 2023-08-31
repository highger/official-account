package com.mgy.official.account.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mgy.official.account.core.model.RankingItem;
import com.mgy.official.account.core.pojo.TFollowInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author mgy
 * @date 2023/8/28
 */
@Mapper
public interface FollowInfoMapper extends BaseMapper<TFollowInfo> {

    List<RankingItem> selectRankingList();
}

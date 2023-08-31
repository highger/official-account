package com.mgy.official.account.core.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.Collection;

public class BaseCoreServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public boolean removeById(Serializable id) {
        Wrapper wrapper = Wrappers.update()
                .eq("id", id)
                .set("gmt_modified", System.currentTimeMillis())
                .set("is_deleted", true);
        return this.update(wrapper);
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public boolean removeByIds(Collection<?> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return false;
        }
        Wrapper wrapper = Wrappers.update()
                .in("id", idList)
                .set("gmt_modified", System.currentTimeMillis())
                .set("is_deleted", true);
        return this.update(wrapper);
    }
}

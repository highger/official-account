package com.mgy.official.account.web.mapper;


import com.mgy.official.account.core.pojo.TMedia;
import com.mgy.official.account.service.res.TemporaryMediaRes;
import com.mgy.official.account.web.vo.TemporaryMediaVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Chyern
 * @since 2021/8/31
 */
@Mapper
public interface MediaMapper {
    MediaMapper INSTANCE = Mappers.getMapper(MediaMapper.class);

    TemporaryMediaVO toTemporaryMediaVO(TemporaryMediaRes temporaryMediaRes);

    List<TemporaryMediaVO> toTemporaryMediaVOList(List<TMedia> mediaList);
}

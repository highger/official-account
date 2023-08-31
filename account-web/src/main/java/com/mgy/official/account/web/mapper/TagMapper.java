package com.mgy.official.account.web.mapper;


import com.mgy.official.account.web.vo.WxUserTagVO;
import me.chanjar.weixin.mp.bean.tag.WxUserTag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Chyern
 * @since 2021/8/31
 */
@Mapper
public interface TagMapper {
    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

    @Mapping(source = "id", target = "tagId")
    WxUserTagVO toWxUserTagVO(WxUserTag wxUserTag);

    List<WxUserTagVO> toWxUserTagVOList(List<WxUserTag> wxUserTagList);


}

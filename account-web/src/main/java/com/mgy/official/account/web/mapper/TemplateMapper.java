package com.mgy.official.account.web.mapper;


import com.mgy.official.account.service.res.TemplateRes;
import com.mgy.official.account.web.vo.TemplateVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Chyern
 * @since 2021/8/31
 */
@Mapper
public interface TemplateMapper {
    TemplateMapper INSTANCE = Mappers.getMapper(TemplateMapper.class);

    @Mapping(source = "template_id", target = "templateId")
    @Mapping(source = "primary_industry", target = "primaryIndustry")
    @Mapping(source = "deputy_industry", target = "deputyIndustry")
    TemplateVO toTemplateVO(TemplateRes templateRes);

    List<TemplateVO> toTemplateVOList(List<TemplateRes> templateResList);


}

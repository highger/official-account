package com.mgy.official.account.service;

import com.mgy.official.account.service.model.TemplateMessage;
import com.mgy.official.account.service.res.TemplateListRes;

/**
 * @author mgy
 * @date 2023/8/25
 */
public interface ITemplateMessageService {
    TemplateListRes getTemplateList();

    Boolean deleteTemplate(String templateId);

    Boolean templateMessageSend(TemplateMessage templateMessage);
}

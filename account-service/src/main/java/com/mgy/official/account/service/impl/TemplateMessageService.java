package com.mgy.official.account.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mgy.official.account.service.ITemplateMessageService;
import com.mgy.official.account.service.model.TemplateMessage;
import com.mgy.official.account.service.model.TemplateValue;
import com.mgy.official.account.service.res.BaseRes;
import com.mgy.official.account.service.res.TemplateListRes;
import com.mgy.official.account.service.res.TemplateSendRes;
import com.mgy.official.account.service.utils.HttpUtils;
import com.mgy.official.account.service.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.stereotype.Service;

/**
 * @author mgy
 * @date 2023/8/25
 */
@Service
@Slf4j
public class TemplateMessageService implements ITemplateMessageService {

    @Override
    public TemplateListRes getTemplateList() {
        String url = String.format("https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=%s", TokenUtils.getAccessToken());
        String getResult = HttpUtils.doGet(url);
        log.info("IndustryService.getIndustry getResult={}", getResult);
        if (StringUtils.isBlank(getResult)) {
            return null;
        }
        return JSON.parseObject(getResult, TemplateListRes.class);
    }

    @Override
    public Boolean deleteTemplate(String templateId) {
        String url = String.format("https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=%s", TokenUtils.getAccessToken());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("template_id", templateId);
        String getResult = HttpUtils.doPost(url, jsonObject.toString());
        log.info("IndustryService.getIndustry getResult={}", getResult);
        if (StringUtils.isBlank(getResult)) {
            return Boolean.FALSE;
        }
        BaseRes baseRes = JSON.parseObject(getResult, BaseRes.class);
        return baseRes.isSuccess();
    }

    @Override
    public Boolean templateMessageSend(TemplateMessage templateMessage) {
        String url = String.format("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s", TokenUtils.getAccessToken());
//        String touser = "ogMs06Xw8rdeXWMCk8Jbl5kIKypw";
//        String template_id = "j9BPjrzlmfJkqLEA1fjHVpjUXdFZ7S8LxqS_q3XG9PM";
//        JSONObject keyWords = new JSONObject();
//        keyWords.put("first", new TemplateValue("恭喜注册成功！"));
//        keyWords.put("keyword1", new TemplateValue("张三"));
//        keyWords.put("keyword2", new TemplateValue("17878787878"));
//        keyWords.put("keyword3", new TemplateValue("2023年9月22日"));
//        keyWords.put("keyword4", new TemplateValue("公众号学习"));
//        keyWords.put("remark", new TemplateValue("欢迎邀请其他小伙伴一起加入！"));
//        TemplateMessage templateMessage = new TemplateMessage();
//        templateMessage.setTouser(touser);
//        templateMessage.setTemplate_id(template_id);
//        templateMessage.setData(keyWords);
        String templateMessageJson = JSON.toJSONString(templateMessage);
        log.info("TemplateService.templateMessageSend templateMessage={}", JSON.toJSONString(templateMessage));
        String result = HttpUtils.doPost(url, templateMessageJson);
        log.info("TemplateService.templateMessageSend result={}", result);
        BaseRes baseRes = JSON.parseObject(result, BaseRes.class);
        return baseRes.isSuccess();
    }

    public static void main(String[] args) {
        JSONObject keyWords = new JSONObject();
        keyWords.put("first", new TemplateValue("恭喜注册成功！"));
        keyWords.put("keyword1", new TemplateValue("张三"));
        keyWords.put("keyword2", new TemplateValue("17878787878"));
        keyWords.put("keyword3", new TemplateValue("2023年9月22日"));
        keyWords.put("keyword4", new TemplateValue("公众号学习"));
        keyWords.put("remark", new TemplateValue("欢迎邀请其他小伙伴一起加入！"));
        System.out.println(keyWords.toString());
        //{"keyword3":{"value":"2023年9月22日"},"keyword4":{"value":"公众号学习"},"keyword1":{"value":"张三"},"keyword2":{"value":"17878787878"},"remark":{"value":"欢迎邀请其他小伙伴一起加入！"},"first":{"value":"恭喜注册成功！"}}
    }

    @Test
    public void sendMessage() {
        String url = String.format("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s", TokenUtils.getAccessToken());
        String touser = "ogMs06Xw8rdeXWMCk8Jbl5kIKypw";
        String template_id = "j9BPjrzlmfJkqLEA1fjHVpjUXdFZ7S8LxqS_q3XG9PM";
        JSONObject keyWords = new JSONObject();
        keyWords.put("first", new TemplateValue("恭喜注册成功！"));
        keyWords.put("keyword1", new TemplateValue("张三"));
        keyWords.put("keyword2", new TemplateValue("17878787878"));
        keyWords.put("keyword3", new TemplateValue("2023年9月22日"));
        keyWords.put("keyword4", new TemplateValue("公众号学习"));
        keyWords.put("remark", new TemplateValue("欢迎邀请其他小伙伴一起加入！"));
        TemplateMessage templateMessage = new TemplateMessage();
        templateMessage.setTouser(touser);
        templateMessage.setTemplate_id(template_id);
        templateMessage.setData(keyWords);
        String templateMessageJson = JSON.toJSONString(templateMessage);
//使用post
        System.out.println(templateMessageJson);
        System.out.println(HttpUtils.doPost(url, templateMessageJson));
    }
}

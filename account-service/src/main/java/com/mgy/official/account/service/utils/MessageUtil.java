package com.mgy.official.account.service.utils;

import com.mgy.official.account.service.model.TextMessage;
import com.thoughtworks.xstream.XStream;

import java.util.Map;

/**
 * @author mgy
 * @date 2023/8/28
 */
public class MessageUtil {

    public static String generateTextMessageForXML(Map<String, String> map, String content) {
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setMsgType("text");
        textMessage.setContent(content);
        textMessage.setCreateTime(System.currentTimeMillis() / 1000); //XStream将Java对象转换成xmL字符串 XStream xStream new XStream();
        XStream xStream = new XStream();
        xStream.processAnnotations(TextMessage.class);
        return xStream.toXML(textMessage);
    }
}

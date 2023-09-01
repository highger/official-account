package com.mgy.official.account.web.controller;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.ocr.AipOcr;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mgy.official.account.common.enums.MediaTypeEnum;
import com.mgy.official.account.core.dao.FollowInfoMapper;
import com.mgy.official.account.core.dao.UserMapper;
import com.mgy.official.account.core.pojo.TFollowInfo;
import com.mgy.official.account.core.pojo.TUser;
import com.mgy.official.account.service.ITemplateMessageService;
import com.mgy.official.account.service.IWxService;
import com.mgy.official.account.service.enums.QrSceneTypeEnum;
import com.mgy.official.account.service.enums.WordsTypeEnum;
import com.mgy.official.account.service.model.*;
import com.mgy.official.account.service.req.ActionInfoReq;
import com.mgy.official.account.service.req.QrCodeReq;
import com.mgy.official.account.service.req.SceneStrReq;
import com.mgy.official.account.service.res.TemplateListRes;
import com.mgy.official.account.service.res.TemplateRes;
import com.mgy.official.account.service.utils.*;
import com.mgy.official.account.web.dto.TemplateMessageDTO;
import com.mgy.official.account.web.mapper.TemplateMapper;
import com.mgy.official.account.web.vo.*;
import com.thoughtworks.xstream.XStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * @author mgy
 * @date 2023/8/25
 */
@RestController
@RequestMapping("/")
@Slf4j
public class MessageController {
    @Resource
    private ITemplateMessageService templateMessageService;
    @Resource
    private IWxService wxService;
    @Resource
    private FollowInfoMapper followInfoMapper;
    @Resource
    private UserMapper userMapper;
    @Value("${redirect.domain}")
    private String redirectDomain;
    @Value("${wechat.open.appId}")
    private String wxAppId;
    @Value("${badui.app.id}")
    private String baiduAppId;
    @Value("${badui.api.key}")
    private String baiduAppKey;
    @Value("${badui.secret.key}")
    private String baiduSecretKey;
    @Value("${account.assistance.success.template}")
    private String assistanceSuccessTemplate;


    /**
     * 客户发消息回复
     * 客户发XX近反义词调用聚合数据功能
     * 客户发图文，返回图片跳转
     * 客户上传图片，识别文字
     *
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(method = RequestMethod.POST)
    public String receiveMessage(HttpServletRequest request) throws IOException {
        System.out.println("收到用户的消息");
        ServletInputStream inputstream = request.getInputStream();

        Map<String, String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        try {
            //读取request:输入流，获得Document:对象
            Document document = reader.read(inputstream); //获得root节点
            Element root = document.getRootElement();//获取所有的子节点
            List<Element> elements = root.elements();
            for (Element element : elements) {
                map.put(element.getName(), element.getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        log.info("收到用户的消息,map={}", JSON.toJSONString(map));
        String message = "";
        String msgType = map.get("MsgType");
        switch (msgType) {
            case "text":
                System.out.println("myContent" + map.get("Content"));
                if (Objects.equals(map.get("Content"), "图文")) {
                    message = getReplyNewsMessage(map);
                } else if (Objects.equals(map.get("Content"), "报名")) {
                    //获得用户授权，拉取用户信息，存入微信号昵称对应表 
                    message = createSignUpRedirectUri(map);
                } else if (Objects.equals(map.get("Content"), "海报")) {
                    message = createPoster(map);
                } else if (Objects.equals(map.get("Content"), "排行榜")) {
                    //点击排行榜查看 
                    message = getRankingLink(map);
                } else {
                    message = getReplyTextMessage(map);
                }
                break;
            case "event":
                if ("subscribe".equals(map.get("Event")) && StringUtils.isNotEmpty(map.get("EventKey"))) {
                    message = handleSubscribe(map);
                } else {
                    message = handleEvent(map);
                }

                break;
            case "image":
                message = handleImage(map);
                break;
            default:
                break;
        }
        return message;

    }

    private String getRankingLink(Map<String, String> map) {
        String url = "http://" + redirectDomain + "/getRankingList";
        String xml = MessageUtil.generateTextMessageForXML(map, "点击查看：<a style='color:#007ecc;' href=\"" + url + "\">助力排行榜</a>");
        return xml;
    }

    private String createPoster(Map<String, String> map) {
        String url = String.format("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=%s", TokenUtils.getAccessToken());
        //String data "\"action_name\":\"OR_LIMIT_STR_SCENE\",\"action_info\":\"scene\ //封装二维码参数
        QrCodeReq grCode = new QrCodeReq();
        grCode.setAction_name(QrSceneTypeEnum.QR_LIMIT_STR_SCENE.name());
        String fromUserName = map.get("FromUserName");
        SceneStrReq sceneStrReq = new SceneStrReq();
        sceneStrReq.setScene_str(fromUserName);
        ActionInfoReq actionInfoReq = new ActionInfoReq();
        actionInfoReq.setScene(sceneStrReq);
        grCode.setAction_info(actionInfoReq);
        String result = HttpUtils.doPost(url, JSON.toJSONString(grCode)); //保存二维码图片至本地，以用户名作为文件名
        String qrPath = getQRCodeImage(result, fromUserName); //合成图片
        //获得用户头像：FromUserName
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TUser::getOpenId, fromUserName);
        TUser user = userMapper.selectOne(queryWrapper);

        String mergeImgPath = "";
        try {
            mergeImgPath = ImageUtil.MergeImage(qrPath, user.getHeadImgUrl(), fromUserName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //上传合成图片资源到微信服务器
        String mediaId = uploadQRCodeImage(mergeImgPath);
        return createImageMessage(map, mediaId);
    }

    private String uploadQRCodeImage(String mergeImgPath) {
        String url = String.format("https://api.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%s", TokenUtils.getAccessToken(), MediaTypeEnum.IMAGE.getCode());
        String result = HttpUtils.doPostByFile(url, null, mergeImgPath, "");
        log.info("MediaService.createTemporaryMedia result={}", result);
        return JSON.parseObject(result).getString("media_id");
    }


    private String createImageMessage(Map<String, String> map, String mediaId) {
        ImageMessage imageMessage = new ImageMessage();
        imageMessage.setToUserName(map.get("FromUserName"));
        imageMessage.setFromUserName(map.get("ToUserName"));
        imageMessage.setCreateTime(System.currentTimeMillis() / 1000);
        imageMessage.setImage(new Image(mediaId));
        imageMessage.setMsgType("image"); //XStream将Java对象转换成xmL字符串
        XStream xStream = new XStream();
        xStream.processAnnotations(ImageMessage.class);
        String xml = xStream.toXML(imageMessage);
        return xml;
    }

    private String getQRCodeImage(String result, String fromUserName) {
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(result);
        String ticketUrl = String.format("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%s", jsonObject.getString("ticket"));

        String path = HttpUtils.download(ticketUrl, fromUserName);
        return path;
    }

    /**
     * 未关注用户扫二维码后关注公众号，推送
     */

    private String handleSubscribe(Map<String, String> map) {
        //解析map
        //EventKey:qrscene_oRQ325LwAb_WyRRs0WsY3g3i6RME
        //将分享者信息和被关注者存入数据库的关注量表和关注记录表-t_follow_.1nfo //获得分享者的微信号
        String sharedUserWxId = getSharedUserWxId(map.get("EventKey"));
        String fromUserName = map.get("FromUserName");
        TFollowInfo followInfo = new TFollowInfo();
        followInfo.setOpenId(sharedUserWxId);
        followInfo.setFollowOpenId(fromUserName);
        followInfo.setFollowTime(System.currentTimeMillis());
        try {
            QueryWrapper<TFollowInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(TFollowInfo::getOpenId, sharedUserWxId)
                    .eq(TFollowInfo::getFollowOpenId, fromUserName);
            List<TFollowInfo> tFollowInfos = followInfoMapper.selectList(queryWrapper);
            if (CollectionUtils.isEmpty(tFollowInfos)) {
                followInfoMapper.insert(followInfo);
            }
        } catch (Exception e) {
        }
        //给分享者推送消息，发送模版消息
        sendModelMessage(sharedUserWxId);
        //用户关注后的回复内容，点击链接->回复“海报”，生成海报
        String url = String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&response_type=code&redirect_uri=%s&scope=%s#wechat_redirect",
                wxAppId,
                //redirect_Uri用户同意后跳转的地址
                "http://" + redirectDomain + "/getSignUpUserInfo", //scope
                "snsapi_userinfo");
        log.info("handleSubscribe.url={}", url);
        String xml = MessageUtil.generateTextMessageForXML(map, "我们正在进行邀请送好礼活动，点击链接：<a href=\"" + url + "\">参与活动</a>");
        return xml;
    }

    private String getSharedUserWxId(String eventKey) {
        return eventKey.replace("qrscene_", "");
    }

    private void sendModelMessage(String sharedUserWxId) {
        String url = String.format("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s", TokenUtils.getAccessToken());
        //查询当前助力值
        QueryWrapper<TFollowInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TFollowInfo::getOpenId, sharedUserWxId);
        Long count = followInfoMapper.selectCount(queryWrapper);//根据目前助力值获得返回内容

        com.alibaba.fastjson.JSONObject keyWords = new com.alibaba.fastjson.JSONObject();
        keyWords.put("first", new TemplateValue("好友助力成功！"));
        keyWords.put("keyword1", new TemplateValue(count + ""));
        keyWords.put("remark", new TemplateValue("欢迎再次邀请其他小伙伴一起加入！"));
        TemplateMessage templateMessage = new TemplateMessage();
        templateMessage.setTouser(sharedUserWxId);
        templateMessage.setTemplate_id(assistanceSuccessTemplate);
        templateMessage.setData(keyWords);
        String templateMessageJson = JSON.toJSONString(templateMessage);
        log.info("MediaService.sendModelMessage templateMessageJson={}", templateMessageJson);

        //使用post
        String result = HttpUtils.doPost(url, templateMessageJson);
        log.info("MediaService.sendModelMessage result={}", result);

    }

    private String createSignUpRedirectUri(Map<String, String> map) {
        //获得关注者的信息（微信号、昵称、头像等）并存入微信号昵称对应表
        //先引导用户访问地址进行授权，之后改用模版消息来封装
        String url = String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&response_type=code&redirect_uri=%s&scope=%s#wechat_redirect",
                wxAppId,
                //redirect_Uri用户同意后跳转的地址
                "http://" + redirectDomain + "/getSignUpUserInfo", //scope
                "snsapi_userinfo");
        log.info("MediaService.createSignUpRedirectUri url={}", url);

        String xml = MessageUtil.generateTextMessageForXML(map, "欢迎关注本公众号" + "点击链接：<a href=\"" + url + "\">参与活动</a>");
        return xml;
    }

    @GetMapping("template/list")
    public AmisResponse<AmisPage<TemplateVO>> getIndustry() {
        log.info("IndustryController.getIndustry init");
        TemplateListRes templateListRes = templateMessageService.getTemplateList();
        if (Objects.isNull(templateListRes)) {
            return AmisResultGenerator.genSuccessResult(AmisPage.empty());
        }
        List<TemplateRes> template_list = templateListRes.getTemplate_list();
        List<TemplateVO> templateVOList = TemplateMapper.INSTANCE.toTemplateVOList(template_list);
        return AmisResultGenerator.genSuccessResult(new AmisPage<>(templateVOList, (long) template_list.size()));
    }


    @DeleteMapping("template")
    public AmisResponse<Boolean> deleteTemplate(String templateId) {
        log.info("IndustryController.deleteTemplate templateId={}", templateId);
        Boolean deleteResult = templateMessageService.deleteTemplate(templateId);
        return AmisResultGenerator.genSuccessResult(deleteResult);
    }

    /**
     * 模版消息推送完成会返回MsgId,随后微信服务器会将是否送达成功作为通知，发送到开发者中心中填写的服务器配置地址中。
     *
     * @param templateMessageDTO
     * @return
     */
    @PostMapping("template/message/send")
    public AmisResponse<Boolean> templateMessageSend(@RequestBody TemplateMessageDTO templateMessageDTO) {
        log.info("IndustryController.templateMessageSend templateMessageDTO={}", JSON.toJSONString(templateMessageDTO));
        TemplateMessage templateMessage = new TemplateMessage();
        templateMessage.setData(JSON.parseObject(templateMessageDTO.getMessageData()));
        templateMessage.setTemplate_id(templateMessageDTO.getTemplateId());
        templateMessage.setTouser(templateMessageDTO.getToUser());
        Boolean deleteResult = templateMessageService.templateMessageSend(templateMessage);
        return AmisResultGenerator.genSuccessResult(deleteResult);
    }


    //getSignUpUserInfo
    @RequestMapping("/getSignUpUserInfo")
    public String getSignUpUserInfo(HttpServletRequest request) {
        //获取code
        String code = request.getParameter("code");
        return wxService.getSignUpUserInfo(code);
    }

    /**
     * 获得排行榜
     */
    @RequestMapping("/getRankingList")
    public String getRankingList() {
        return wxService.getRankingList();
    }

    //=====================================================================================================================


    private String handleImage(Map<String, String> map) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(baiduAppId, baiduAppKey, baiduSecretKey);


        String url = map.get("PicUrl");

        // 网络图片文字识别, 图片参数为远程url图片
        JSONObject res = client.webImageUrl(url, new HashMap<>());
        System.out.println(res.toString());
        /*
        {
            "log_id": 2471272194,
            "words_result_num": 2,
            "words_result":
                [
                    {"words": " TSINGTAO"},
                    {"words": "青島睥酒"}
                ]
           }
         */
        JSONArray wordsResult = res.getJSONArray("words_result");
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Object> iterator = wordsResult.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonobject = (JSONObject) iterator.next();
            stringBuilder.append(jsonobject.getString("words"));
        }

        return createTextMessage(stringBuilder.toString(), map);
    }

    private String createTextMessage(String content, Map<String, String> map) {
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

    private String handleEvent(Map<String, String> map) {
        String event = map.get("Event");
        switch (event) {
            case "CLICK":
                if ("CLICK_NORMAN".equals(map.get("EventKey"))) {
                    TextMessage textMessage = new TextMessage();
                    textMessage.setToUserName(map.get("FromUserName"));
                    textMessage.setFromUserName(map.get("ToUserName"));
                    textMessage.setMsgType("text");
                    textMessage.setContent("你点击了event key是CLICK_NORMAN的按钮");
                    textMessage.setCreateTime(System.currentTimeMillis() / 1000);
                    //XStream将Java对象转换成xmL字符串
                    XStream xStream = new XStream();
                    xStream.processAnnotations(TextMessage.class);
                    return xStream.toXML(textMessage);
                }
                break;
            case "VIEW":
                System.out.println("view");
                break;
            default:
                break;
        }
        return null;
    }

    private String getReplyNewsMessage(Map<String, String> map) {
        NewMessage textMessage = new NewMessage();
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setMsgType("news");
        textMessage.setCreateTime(System.currentTimeMillis() / 1000);
        textMessage.setArticleCount(1);
        List<Article> articleList = new ArrayList<>();
        Article article = new Article();
        article.setTitle("我的图文");
        article.setDescription("具体描述");
        article.setUrl("https://www.baidu.com");
        article.setPicUrl("https://img0.baidu.com/it/u=3501038345,2787595729&fm=253&fmt=auto&f=JPEG?w=300&h=200");
        articleList.add(article);
        textMessage.setArticles(articleList);
        //XStream将Java对象转换成xmL字符串
        XStream xStream = new XStream();
        xStream.processAnnotations(NewMessage.class);
        return xStream.toXML(textMessage);
    }

    private String getReplyTextMessage(Map<String, String> map) {
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setMsgType("text");
        String content = map.get("Content");
        String type = "";
        String newContent = null;
        if ((content.contains("的近义词") || content.contains("的反义词"))) {
            if (content.contains("的近义词")) {
                type = "1";
                int i = content.indexOf("的近义词");
                newContent = content.substring(0, i);
            } else if (content.contains("的反义词")) {
                type = "2";
                int i = content.indexOf("的反义词");
                newContent = content.substring(0, i);
            }
            if (StringUtils.isNotBlank(type)) {
                System.out.println("newContent" + newContent);
                List<String> list = JuheUtils.JuheWords(newContent, type);
                if (CollectionUtils.isEmpty(list)) {
                    textMessage.setContent("没找到" + newContent + "的" + WordsTypeEnum.getWordsTypeEnum(type).getMsg() + "，换一个试试");
                } else {
                    textMessage.setContent(newContent + WordsTypeEnum.getWordsTypeEnum(type).getMsg() + "是：" + String.join("，", list));
                }
            } else {
                textMessage.setContent("你可以回复：XX的近义词");
            }
        } else {
            textMessage.setContent("欢迎扩散公众号：程序员成长有道\n主人，已为你找到相关文档：\n👉<a href=\\\"\"https://www.baidu.com/s?wd=" + content + "\"\\\">" + content + "</a>");
        }

        textMessage.setCreateTime(System.currentTimeMillis() / 1000);
        //XStream将Java对象转换成xmL字符串
        XStream xStream = new XStream();
        xStream.processAnnotations(TextMessage.class);
        return xStream.toXML(textMessage);
    }


}

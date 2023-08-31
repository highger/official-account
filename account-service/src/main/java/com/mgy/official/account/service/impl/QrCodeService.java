package com.mgy.official.account.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mgy.official.account.service.IQrCodeService;
import com.mgy.official.account.service.enums.QrSceneTypeEnum;
import com.mgy.official.account.service.req.ActionInfoReq;
import com.mgy.official.account.service.req.QrCodeReq;
import com.mgy.official.account.service.req.SceneIdReq;
import com.mgy.official.account.service.utils.HttpUtils;
import com.mgy.official.account.service.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author mgy
 * @date 2023/8/28
 */
@Slf4j
@Service
public class QrCodeService implements IQrCodeService {
@Override
public String getTemporaryQrCode(QrCodeReq qrCodeReq){
       String url = String.format("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=%s", TokenUtils.getAccessToken());
//       QrCodeReq qrCodeReq = new QrCodeReq();
//       qrCodeReq.setExpire_seconds(604800);
//       qrCodeReq.setAction_name(QrSceneTypeEnum.QR_SCENE.name());
//
//       ActionInfoReq action_info = new ActionInfoReq();
//       SceneIdReq scene = new SceneIdReq();
//       scene.setScene_id(123);
//       action_info.setScene(scene);
//       qrCodeReq.setAction_info(action_info);
       log.info("ButtonService.deleteButton qrCodeReq={}", JSON.toJSONString(qrCodeReq));
       String result = HttpUtils.doPost(url, JSON.toJSONString(qrCodeReq));
       log.info("ButtonService.deleteButton result={}", result);
       JSONObject jsonObject = JSON.parseObject(result);
       String ticket = jsonObject.getString("ticket");
       return String.format("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%s", ticket);
   }

}

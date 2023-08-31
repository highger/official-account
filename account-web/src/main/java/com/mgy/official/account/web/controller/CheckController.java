package com.mgy.official.account.web.controller;

import com.alibaba.fastjson.JSON;
import com.mgy.official.account.web.dto.UpdateTestDTO;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author mgy
 * @date 2023/8/23
 */
@RestController
@RequestMapping("/")
@Slf4j
public class CheckController {
    @Resource
    private WxMpService wxMpService;

    @RequestMapping(method = RequestMethod.GET)
    public String check(String signature,
                        String timestamp,
                        String nonce,
                        String echostr) {
        System.out.println("signature:" + signature);
        System.out.println("timestamp:" + timestamp);
        System.out.println("nonce:" + nonce);
        System.out.println("echostr:" + echostr);
        return wxMpService.checkSignature(timestamp, nonce, signature) ? echostr : null;
//        //I)将token、timestamp、nonce.三个参数进行字典序排序
//        String token = "norman";
//        List<String> list = Arrays.asList(token, timestamp, nonce); //排序
//        Collections.sort(list);
//        //2)将三个参数字符串拼接成一个字符串进行sha1加密
//        StringBuilder stringBuilder = new StringBuilder();
//        for (String s : list) {
//            stringBuilder.append(s);
//        }
//        //加密
//        try {
//            MessageDigest instance = MessageDigest.getInstance("sha1"); //使用sha1进行加密，获得byte数组
//            byte[] digest = instance.digest(stringBuilder.toString().getBytes());
//            StringBuilder sum = new StringBuilder();
//            for (byte b : digest) {
//                sum.append(Integer.toHexString((b >> 4) & 15));
//                sum.append(Integer.toHexString(b & 15));
//            }
//            if (!StringUtils.isEmpty(signature) && signature.equals(sum.toString())) {
//                return echostr;
//            }
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        return null;
    }


    @RequestMapping(value = "key", method = RequestMethod.GET)
    public String getKey() {
        log.info("key controller getKeygetKey");
        return "Key";
    }

    /*
fetch(new Request('http://localhost:8080/key/sdhsjf',{
    method:'POST',
    headers: {'Content-Type': 'application/x-www-form-urlencoded',
'Cookie':'REDISSESSION=b687928a-667c-405d-862d-9d4f1fedf3d6',
'X-CSRFtoken':'38cb064648608e2286e51a399a2328d9'}
})).then((resp)=>{console.log(resp)})
     */
    @RequestMapping(value = "key/{appCode}", method = RequestMethod.POST)
    public Boolean addKey(@PathVariable("appCode") String appCode) {
        log.info("key controller add key appCode={}", appCode);
        return true;
    }

    /*
fetch(new Request('http://localhost:8080/keys/sdhsjf',{
    method:'PUT',
    headers: {'Content-Type': 'application/json',
'Cookie':'REDISSESSION=b687928a-667c-405d-862d-9d4f1fedf3d6',
'X-CSRFtoken':'38cb064648608e2286e51a399a2328d9'},
    body:"{\"uid\":\"hjf\",\"name\":\"hahaha\",\"age\":12}"
})).then((resp)=>{console.log(resp)})
     */
    @RequestMapping(value = "keys/{appCode}", method = RequestMethod.PUT)
    public Boolean updateKey(@PathVariable("appCode") String appCode, @RequestBody UpdateTestDTO updateTestDTO) {
        log.info("key controller add key updateReq={},appCode={}", JSON.toJSONString(updateTestDTO), appCode);
        return true;
    }


}
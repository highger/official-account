package com.mgy.official.account.web.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mgy.official.account.core.dao.UserMapper;
import com.mgy.official.account.core.pojo.TUser;
import com.mgy.official.account.service.model.*;
import com.mgy.official.account.service.utils.HttpUtils;
import com.mgy.official.account.service.utils.TokenUtils;
import com.mgy.official.account.web.vo.AmisPage;
import com.mgy.official.account.web.vo.AmisResponse;
import com.mgy.official.account.web.vo.AmisResultGenerator;
import com.mgy.official.account.web.vo.MenuVO;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpMenuService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义菜单功能
 * 可以不删除，直接创建就行
 *
 * @author mgy
 * @date 2023/8/24
 */
@RestController
@Slf4j
public class MenuController {
    @Resource
    private WxMpService wxMpService;
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private UserMapper userMapper;

    //{"button":[{"type":"click","name":"norman","key":"CLICK_NORMAN"},{"type":"view","name":"baidu","url":"http://www.baidu.com"},{"name":"更多","sub_button":[{"type":"view","name":"涂鸦","url":"https://iot.tuya.com"},{"type":"pic_photo_or_album","name":"上传图片","key":"CLICK_PHOTO"}]}]}
    @PostMapping("/button")
    public AmisResponse createMenu(String buttonJson) throws WxErrorException {
        log.info("ButtonController.createButton buttonJson={}", buttonJson);
        String menuId = wxMpService.getMenuService().menuCreate(JSON.parseObject(buttonJson).toString());
        return AmisResultGenerator.genSuccessResult();
    }

    @GetMapping("/button")
    public AmisResponse<AmisPage<MenuVO>> getMenu() throws WxErrorException {
        log.info("ButtonController.getMenu");
        WxMpMenuService menuService = wxMpService.getMenuService();
        WxMpMenu wxMpMenu = menuService.menuGet();
        log.info("ButtonController.getMenu wxMpMenu={}", JSON.toJSONString(wxMpMenu));

        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("key", "value");

        String key = jedis.get("key");
        log.info("ButtonController.getMenu key={}", key);

        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("key2", "value2");
        Object key2 = valueOperations.get("key2");
        log.info("ButtonController.getMenu key2={}", key2);
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        UpdateWrapper<TUser> updateWrapper = new UpdateWrapper<>();

        TUser tUser = new TUser();
        tUser.setHeadImgUrl("baidu.com");
        tUser.setNickName("zhangsna");
        tUser.setOpenId("sandhsddjs");
        tUser.setSex(1);
        tUser.setCity("beijing");
        tUser.setProvince("安徽");
//        int insert = userMapper.insert(tUser);
//        log.info("ButtonController.getMenu inserttUser={}", insert);

        List<TUser> allTUser = userMapper.selectList(Wrappers.lambdaQuery());
        log.info("ButtonController.getMenu allTUser={}", JSON.toJSONString(allTUser));

        MenuVO menuVO = new MenuVO();
        menuVO.setMenu(JSON.toJSONString(wxMpMenu.getMenu()));
        return AmisResultGenerator.genSuccessResult(new AmisPage<>(List.of(menuVO), 1L));
    }


    public static void main(String[] args) {
        //创建一级菜单
        Menu menu = new Menu();
        List<AbstractMenu> buttons = new ArrayList<>();
        //一级菜单中的第一个按钮
        ClickMenu clickMenu = new ClickMenu("norman", "CLICK_NORMAN");
        //一级菜单中的第二个按钮
        ViewMenu viewMenu = new ViewMenu("baidu", "http://www.baidu.com");
        //一级菜单中的第三个按钮（二级菜单）
        SubMenu subButton = new SubMenu("更多");
        List<AbstractMenu> subButtons = new ArrayList<>(); //二级菜单的第一个按钮
        //二级菜单的第一个按钮
        subButtons.add(new ViewMenu("涂鸦", "https://iot.tuya.com/"));
        //二级菜单的第二个按钮
        subButtons.add(new PhotoPrAlbumMenu("上传图片", "CLICK_PHOTO"));
        subButton.setSub_button(subButtons);
        //把一级菜单中的三个按钮添加进集合
        buttons.add(clickMenu);
        buttons.add(viewMenu);
        buttons.add(subButton);
        //把集合添加到一级菜单中
        menu.setButton(buttons);

        //转换成json字符串
        String json = JSON.toJSONString(menu);
        String url = String.format("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s", TokenUtils.getAccessToken());
        String result = HttpUtils.doPost(url, json);
        System.out.println(result);
    }
}

package com.mgy.official.account.web.controller;

import com.mgy.official.account.web.common.EnvHelper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mgy
 * @date 2023/8/23
 */
@Controller
@RequestMapping("/")
@Slf4j
public class IndexController {

    @RequestMapping("page")
    public String amisIndex(Model model, ModelMap map) {
        map.put("host", AmisHostEnum.getCurrentHostUrl());
        map.put("env", EnvHelper.getEnv());
        System.out.println(map);
        return "index";
    }

//    @RequestMapping("/amis/index")
//    public String amisGuideIndex(Model model, ModelMap map) {
//        return "guide";
//    }

    @Getter
    enum AmisHostEnum {
        /**
         *
         */
        DEV("开发", "dev", "http://localhost:8080");

        AmisHostEnum(String name, String env, String url) {
            this.name = name;
            this.env = env;
            this.url = url;
        }

        private String name;
        private String env;
        private String url;

        public static String getCurrentHostUrl() {
            return AmisHostEnum.DEV.url;
        }

    }
}
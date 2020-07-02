package com.example.dmdemo.control;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：
 * @Author：GuoFeng
 * @CreateTime：2020-07-02
 */
@Slf4j
@RestController
public class UserInfoController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        log.info("UserInfoController.index————》Springboot 测试达梦数据库！");
        return "Springboot 测试达梦数据库！";
    }

}

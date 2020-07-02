package com.example.dmdemo.control;

import com.alibaba.fastjson.JSON;
import com.example.dmdemo.bean.UserInfo;
import com.example.dmdemo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description：
 * @Author：GuoFeng
 * @CreateTime：2020-07-02
 */
@Slf4j
@RestController
public class UserInfoController {

    @Autowired
    protected UserInfoService userInfoService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        log.info("UserInfoController.index————》Springboot 测试达梦数据库！");
        return "Springboot 测试达梦数据库！";
    }

    @GetMapping("/getAll")
    public List<UserInfo> getAll() {
        List<UserInfo> userInfoList = null;
        log.info("UserInfoController.getAll————》start");
        try {
            userInfoList = this.userInfoService.getAll();
        } catch (Exception e) {
            log.error("UserInfoController.getAll————》error【{}，{}】", e.getMessage(), e);
        }
        log.info("UserInfoController.getAll————》end【{}】", JSON.toJSONString(userInfoList));
        return userInfoList;
    }

}

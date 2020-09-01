package com.example.dmdemo.control;

import com.alibaba.fastjson.JSON;
import com.example.dmdemo.bean.UserInfo;
import com.example.dmdemo.common.ResultObject;
import com.example.dmdemo.service.UserInfoService;
import com.example.dmdemo.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * http://localhost:8080/index.html
     *
     * @return
     */
    @GetMapping("/getAll")
    public ResultObject getAll1() {
        try {
            log.info("UserInfoController.getAll————》start");
            List<UserInfo> userInfoList = this.userInfoService.getAll();
            log.info("UserInfoCotroller.getAll————》end【{}】", JSON.toJSONString(userInfoList));
            return ResultObject.successData(userInfoList, "查询成功！");
        } catch (Exception e) {
            log.error("UserInfoController.getAll————》error【{}，{}】", e.getMessage(), e);
            return ResultObject.successMsg("查询失败！");
        }
    }

    /**
     * URL: http://localhost:8080/user.html
     *
     * @return
     */
    @PostMapping("/getAll")
    public List<UserInfo> getAll() {
        List<UserInfo> userInfoList = null;
        try {
            log.info("UserInfoController.getAll————》start");
            userInfoList = this.userInfoService.getAll();
            log.info("UserInfoCotroller.getAll————》end【{}】", JSON.toJSONString(userInfoList));
            return userInfoList;
        } catch (Exception e) {
            log.error("UserInfoController.getAll————》error【{}，{}】", e.getMessage(), e);
            return userInfoList;
        }
    }

    @PostMapping(value = "/getUserInfoPage")
    public ResultObject getUserInfoPage(@RequestBody UserInfoVo request) {
        try {
            log.info("分页查询 UserInfoController.getUserInfoPage，start————>{}", JSON.toJSONString(request));
            ResultObject responseData = this.userInfoService.getUserInfoPage(request);
            log.info("分页查询 UserInfoController.getUserInfoPage，end————>{}", JSON.toJSONString(responseData));
            return responseData;
        } catch (Exception e) {
            log.error("分页查询 UserInfoController.getUserInfoPage，error————>[{},{}]", e.getMessage(), e);
            return ResultObject.error("查询失败！");
        }
    }

    /**
     * 根据id查询UserInfo
     * URL: http://localhost:8080/user/1
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/user/{id}")
    public ResultObject getUserById(@PathVariable Long id) {
        return this.userInfoService.selectByPrimaryKey(id);
    }

}

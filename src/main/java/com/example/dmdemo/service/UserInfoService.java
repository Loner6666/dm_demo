package com.example.dmdemo.service;

import com.example.dmdemo.bean.UserInfo;

import java.util.List;

/**
 * @Description：
 * @Author：GuoFeng
 * @CreateTime：2020-07-02
 */
public interface UserInfoService {

    List<UserInfo> getAll() throws Exception;

}

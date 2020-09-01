package com.example.dmdemo.service;

import com.example.dmdemo.bean.UserInfo;
import com.example.dmdemo.common.ResultObject;
import com.example.dmdemo.vo.UserInfoVo;

import java.util.List;

/**
 * @Description：
 * @Author：GuoFeng
 * @CreateTime：2020-07-02
 */
public interface UserInfoService {

    List<UserInfo> getAll() throws Exception;

    ResultObject getUserInfoPage(UserInfoVo request) throws Exception;

    ResultObject selectByPrimaryKey(Long id);

}

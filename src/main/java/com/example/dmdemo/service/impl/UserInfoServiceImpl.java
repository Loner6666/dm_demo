package com.example.dmdemo.service.impl;

import com.example.dmdemo.bean.UserInfo;
import com.example.dmdemo.mapper.UserInfoMapper;
import com.example.dmdemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description：
 * @Author：GuoFeng
 * @CreateTime：2020-07-02
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getAll() throws Exception {
        return userInfoMapper.getAll();
    }

}

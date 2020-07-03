package com.example.dmdemo.service.impl;

import com.example.dmdemo.bean.UserInfo;
import com.example.dmdemo.common.ResultObject;
import com.example.dmdemo.mapper.UserInfoMapper;
import com.example.dmdemo.service.UserInfoService;
import com.example.dmdemo.vo.UserInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public ResultObject getUserInfoPage(UserInfoVo request) throws Exception {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<UserInfoVo> userInfoList = this.userInfoMapper.getUserInfoPage(request);
        PageInfo<UserInfoVo> pageInfo = new PageInfo(userInfoList);
        return ResultObject.successData(pageInfo);
    }

}

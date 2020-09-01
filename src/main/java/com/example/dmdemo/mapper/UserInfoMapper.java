package com.example.dmdemo.mapper;

import com.example.dmdemo.bean.UserInfo;
import com.example.dmdemo.vo.UserInfoVo;

import java.util.List;

public interface UserInfoMapper {

    List<UserInfo> getAll();

    List<UserInfoVo> getUserInfoPage(UserInfoVo userInfoVo);

    UserInfo selectByPrimaryKey(Long id);

}
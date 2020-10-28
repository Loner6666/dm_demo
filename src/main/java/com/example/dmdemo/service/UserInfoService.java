package com.example.dmdemo.service;

import com.example.dmdemo.bean.UserInfo;
import com.example.dmdemo.common.ResultObject;
import com.example.dmdemo.vo.UserInfoVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description：
 * @Author：GuoFeng
 * @CreateTime：2020-07-02
 */
public interface UserInfoService {

    /**
     * 查询user_info
     *
     * @return
     * @throws Exception
     */
    List<UserInfo> getAll() throws Exception;

    /**
     * 分页查询
     *
     * @param request
     * @return
     * @throws Exception
     */
    ResultObject getUserInfoPage(UserInfoVo request) throws Exception;

    /**
     * 根据id查询UserInfo
     *
     * @param id
     * @return
     */
    ResultObject selectByPrimaryKey(Long id);

    /**
     * 导出Excel
     *
     * @param request
     * @param response
     * @return
     */
    ResultObject export(HttpServletRequest request, HttpServletResponse response);

}

package com.example.dmdemo.service.impl;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.fastjson.JSON;
import com.example.dmdemo.bean.UserInfo;
import com.example.dmdemo.common.ResultObject;
import com.example.dmdemo.mapper.UserInfoMapper;
import com.example.dmdemo.service.UserInfoService;
import com.example.dmdemo.utils.RedisUtils;
import com.example.dmdemo.vo.UserInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description：
 * @Author：GuoFeng
 * @CreateTime：2020-07-02
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private RedisUtils redisUtils;

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

    @Override
    public ResultObject selectByPrimaryKey(Long id) {
        try {
            final String key = "USERINFO_ID_" + id;
            log.info("根据id查询UserInfo，start————>{}", JSON.toJSONString(key));
            Object value = null;
            if (redisUtils.exists(key)) {
                //如果Redis中有，直接返回
                value = redisUtils.get(key);
                log.info("从Redis中返回：【{}】", value);
            } else {
                //第一次从数据库查询，并存入Redis
                UserInfo userInfo = this.userInfoMapper.selectByPrimaryKey(id);
                value = JSON.toJSONString(userInfo);
                //过期时间一分钟
                redisUtils.set(key, value, 60L);
                log.info("第一次从数据库查询：【{}】", value);
            }
            log.info("根据id查询UserInfo，end————>{}", value);
            return ResultObject.successData(JSON.parseObject(value.toString(), UserInfo.class));
        } catch (Exception e) {
            log.error("根据id查询UserInfo，error————>[{},{}]", e.getMessage(), e);
            return ResultObject.error("查询失败！");
        }
    }

    @Override
    public ResultObject export(HttpServletRequest request, HttpServletResponse response) {
        try {
            //获取数据
            log.info("导出Excel开始，获取数据————》");
            List<UserInfo> userInfoList = this.userInfoMapper.getAll();
            log.info("导出Excel的数据为：{}", JSON.toJSONString(userInfoList));
            String fileName = new String("海贼王人物信息表.xlsx".getBytes(), "ISO-8859-1");
            response.addHeader("Content-Disposition", "filename=" + fileName);
            ServletOutputStream out = response.getOutputStream();
            // 写出 Excel 文件
            EasyExcelFactory.write(out, UserInfo.class).sheet("UserInfo数据").doWrite(userInfoList);
            log.info("Excel导出成功！");
            return ResultObject.successMsg("导出成功！");
        } catch (IOException e) {
            log.error("Excel导出失败！");
            return ResultObject.error("导出失败！");
        }
    }

}

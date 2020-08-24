package com.example.dmdemo.vo;

import com.example.dmdemo.bean.UserInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description：
 * @Author：GuoFeng
 * @CreateTime：2020-07-03
 */
@Data
public class UserInfoVo extends UserInfo implements Serializable {

    private static final long serialVersionUID = 5629544956865594289L;

    private Integer pageNum; // 分页起始条
    private Integer pageSize; // 每页显示条数
    private Integer pageTotal; // 总条数

}

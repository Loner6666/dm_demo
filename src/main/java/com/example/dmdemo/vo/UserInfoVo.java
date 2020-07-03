package com.example.dmdemo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description：
 * @Author：GuoFeng
 * @CreateTime：2020-07-03
 */
@Data
public class UserInfoVo implements Serializable {

    private static final long serialVersionUID = 5629544956865594289L;

    private long id;
    private String name;
    private long age;

    private Integer pageNum; // 分页起始条
    private Integer pageSize; // 每页显示条数
    private Integer pageTotal; // 总条数

}

package com.example.dmdemo.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * user_info数据表 实体类
 *
 * @author GuoFeng
 */
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -6390482996068465607L;

    @ExcelProperty(value = "编号", index = 0)
    private long id;
    @ExcelProperty(value = "姓名", index = 1)
    private String name;
    @ExcelProperty(value = "年龄", index = 2)
    private long age;

}

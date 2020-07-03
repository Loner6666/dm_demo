package com.example.dmdemo.common;

import com.example.dmdemo.enums.ErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description：
 * @Author：GuoFeng
 * @CreateTime：2020-07-03
 */
@Data
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;

    public int code;
    public String message;

    public Result() {
        this.code = ErrorCode.OK.getCode();
        this.message = ErrorCode.OK.getMessage();
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

}

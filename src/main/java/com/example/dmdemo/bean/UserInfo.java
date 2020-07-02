package com.example.dmdemo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuoFeng
 */
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -6390482996068465607L;

    private long id;
    private String name;
    private long age;

}

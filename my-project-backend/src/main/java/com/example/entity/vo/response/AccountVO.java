package com.example.entity.vo.response;

import lombok.Data;

import java.util.Date;

@Data
/**
 * 用户基础信息响应体。
 */
public class AccountVO {
    /**
     * 用户名。
     */
    String username;
    /**
     * 邮箱。
     */
    String email;
    /**
     * 角色标识。
     */
    String role;
    /**
     * 注册时间。
     */
    Date registerTime;
}

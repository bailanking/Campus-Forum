package com.example.entity.vo.response;

import lombok.Data;

@Data
/**
 * 用户详情资料响应体。
 */
public class AccountDetailsVO {

    /**
     * 性别标识。
     */
    int gender;
    /**
     * 手机号。
     */
    String phone;
    /**
     * QQ 号。
     */
    String qq;
    /**
     * 微信号。
     */
    String wx;
    /**
     * 个人简介。
     */
    String desc;
}

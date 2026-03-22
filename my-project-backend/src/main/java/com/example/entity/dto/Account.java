package com.example.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.entity.BaseData;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 数据库中的用户信息
 */
@Data
@TableName("db_account")
@AllArgsConstructor
/**
 * 账号基础信息实体。
 */
public class Account implements BaseData {
    /**
     * 主键 ID。
     */
    @TableId(type = IdType.AUTO)
    Integer id;
    /**
     * 登录用户名。
     */
    String username;
    /**
     * 已加密的登录密码。
     */
    String password;
    /**
     * 唯一邮箱地址。
     */
    String email;
    /**
     * 角色标识（不含 ROLE_ 前缀）。
     */
    String role;
    /**
     * 注册时间。
     */
    Date registerTime;
}

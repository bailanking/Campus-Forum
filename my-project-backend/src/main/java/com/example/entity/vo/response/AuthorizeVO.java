package com.example.entity.vo.response;

import lombok.Data;

import java.util.Date;

/**
 * 登录验证成功的用户信息响应
 */
@Data
/**
 * 登录成功后的认证响应体。
 */
public class AuthorizeVO {
    /**
     * 用户名。
     */
    String username;
    /**
     * 当前角色。
     */
    String role;
    /**
     * 登录成功后返回的 JWT。
     */
    String token;
    /**
     * JWT 过期时间。
     */
    Date expire;
}

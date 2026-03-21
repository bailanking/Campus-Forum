package com.example.entity.vo.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 用户注册表单信息
 */
@Data
public class EmailRegisterVO {
    /**
     * 注册邮箱地址。
     */
    @Email
    String email;
    /**
     * 邮箱验证码。
     */
    @Length(max = 6, min = 6)
    String code;
    /**
     * 用户名，仅允许中英文和数字。
     */
    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]+$")
    @Length(min = 1, max = 10)
    String username;
    /**
     * 登录密码。
     */
    @Length(min = 6, max = 20)
    String password;
}

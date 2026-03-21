package com.example.entity.vo.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 密码重置表单实体
 */
@Data
public class EmailResetVO {
    /**
     * 需要重置密码的邮箱地址。
     */
    @Email
    String email;
    /**
     * 邮箱验证码。
     */
    @Length(max = 6, min = 6)
    String code;
    /**
     * 新密码。
     */
    @Length(min = 6, max = 20)
    String password;
}

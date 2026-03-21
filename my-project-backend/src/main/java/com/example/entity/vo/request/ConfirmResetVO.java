package com.example.entity.vo.request;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 找回密码第一步的确认参数：邮箱 + 验证码。
 */
@Data
@AllArgsConstructor
public class ConfirmResetVO {
    /**
     * 待重置账户的邮箱地址。
     */
    @Email
    String email;
    /**
     * 邮箱收到的 6 位验证码。
     */
    @Length(max = 6, min = 6)
    String code;
}

package com.example.entity.vo.request;

import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
/**
 * 修改邮箱请求体。
 */
public class ModifyEmailVO {
    /**
     * 新绑定邮箱地址。
     */
    @Email
    String email;
    /**
     * 邮箱验证码。
     */
    @Length(min = 6, max = 6)
    String code;
}

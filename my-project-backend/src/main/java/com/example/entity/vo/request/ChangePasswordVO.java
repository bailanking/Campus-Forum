package com.example.entity.vo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
/**
 * 修改密码请求体。
 */
public class ChangePasswordVO {
    /**
     * 原密码。
     */
    @Length(min = 6, max = 20)
    String password;
    /**
     * 新密码。
     */
    @Length(min = 6, max = 20)
    String new_password;
}

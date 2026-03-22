package com.example.entity.vo.response;

import lombok.Data;

@Data
/**
 * 用户隐私配置响应体，返回各资料项是否可对外展示。
 */
public class AccountPrivacyVO {

    /**
     * 手机号展示开关。
     */
    boolean phone;
    /**
     * 邮箱展示开关。
     */
    boolean email;
    /**
     * QQ 展示开关。
     */
    boolean qq;
    /**
     * 微信展示开关。
     */
    boolean wx;
    /**
     * 性别展示开关。
     */
    boolean gender;
}

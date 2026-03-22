package com.example.entity.vo.request;

import com.example.entity.BaseData;
import com.example.entity.RestBean;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Data
/**
 * 用户详情资料保存请求体。
 */
public class DetailsSaveVO {

    /**
     * 用户名，保存资料时会同步更新账号用户名。
     */
    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]+$")
    @Length(min = 1, max = 10)
    String username;
    /**
     * 性别标识，0/1。
     */
    @Min(0)
    @Max(1)
    int gender;
    /**
     * 手机号。
     */
    @Length(max = 10)
    String phone;
    /**
     * QQ 号。
     */
    @Length(max = 13)
    String qq;
    /**
     * 微信号。
     */
    @Length(max = 20)
    String wx;
    /**
     * 个人简介。
     */
    @Length(max = 200)
    String desc;
}

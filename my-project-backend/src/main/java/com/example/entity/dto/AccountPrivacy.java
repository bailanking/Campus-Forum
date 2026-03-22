package com.example.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.entity.BaseData;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("db_account_privacy")
/**
 * 用户隐私配置实体，对应每个可展示字段的公开状态。
 */
public class AccountPrivacy implements BaseData {
    /**
     * 主键，与账号 ID 一致。
     */
    @TableId(type = IdType.AUTO)
    private final Integer id;
    /**
     * 手机号是否允许展示。
     */
    boolean phone = true;
    /**
     * 邮箱是否允许展示。
     */
    boolean email = true;
    /**
     * QQ 是否允许展示。
     */
    boolean qq = true;
    /**
     * 微信是否允许展示。
     */
    boolean wx = true;
    /**
     * 性别是否允许展示。
     */
    boolean gender = true;
}

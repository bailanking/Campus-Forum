package com.example.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.entity.BaseData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("db_account_details")
@AllArgsConstructor
@NoArgsConstructor
/**
 * 用户详情资料实体。
 */
public class AccountDetails implements BaseData {
    /**
     * 主键，与账号 ID 一致。
     */
    @TableId
    Integer id;
    /**
     * 性别标识。
     */
    int gender;
    /**
     * 手机号。
     */
    String phone;
    /**
     * QQ 号。
     */
    String qq;
    /**
     * 微信号。
     */
    String wx;
    /**
     * 个人简介，对应数据库关键字字段 `desc`。
     */
    @TableField("`desc`")
    String desc;
}

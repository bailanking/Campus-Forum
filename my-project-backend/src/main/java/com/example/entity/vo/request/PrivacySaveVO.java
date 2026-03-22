package com.example.entity.vo.request;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
/**
 * 隐私配置保存请求体。
 */
public class PrivacySaveVO {
    /**
     * 需要更新的隐私字段类型。
     */
    @Pattern(regexp = "(phone|email|qq|wx|gender)")
    String type;
    /**
     * 目标开关状态，true 为公开，false 为隐藏。
     */
    boolean status;
}

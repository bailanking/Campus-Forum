package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.dto.AccountPrivacy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
/**
 * 用户隐私配置表 Mapper。
 */
public interface AccountPrivacyMapper extends BaseMapper<AccountPrivacy> {
}

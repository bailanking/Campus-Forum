package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.dto.AccountDetails;
import org.apache.ibatis.annotations.Mapper;

@Mapper
/**
 * 用户详情资料表 Mapper。
 */
public interface AccountDetailsMapper extends BaseMapper<AccountDetails> {
}

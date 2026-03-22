package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.dto.AccountDetails;
import com.example.entity.vo.request.DetailsSaveVO;

/**
 * 用户详情资料服务，负责详情查询与保存。
 */
public interface AccountDetailsService extends IService<AccountDetails> {
    /**
     * 按用户 ID 查询详情资料。
     */
    AccountDetails findAccountDetailsById(int id);

    /**
     * 保存用户资料，并同步更新用户名。
     */
    boolean saveAccountDetails(int id, DetailsSaveVO detailsSaveVO);
}

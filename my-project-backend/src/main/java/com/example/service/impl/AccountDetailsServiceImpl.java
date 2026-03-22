package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.dto.Account;
import com.example.entity.dto.AccountDetails;
import com.example.entity.vo.request.DetailsSaveVO;
import com.example.mapper.AccountDetailsMapper;
import com.example.service.AccountDetailsService;
import com.example.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
/**
 * 用户详情资料服务实现。
 */
public class AccountDetailsServiceImpl extends ServiceImpl<AccountDetailsMapper, AccountDetails> implements AccountDetailsService {

    /**
     * 账号服务，用于用户名唯一性校验和用户名更新。
     */
    @Resource
    AccountService service;

    /**
     * 查询用户详情资料。
     */
    @Override
    public AccountDetails findAccountDetailsById(int id) {
        return this.getById(id);
    }

    /**
     * 保存用户详情资料并同步用户名。
     */
    @Override
    @Transactional
    public synchronized boolean saveAccountDetails(int id, DetailsSaveVO vo) {
        Account account = service.findAccountByNameOrEmail(vo.getUsername());
        if (account == null || account.getId() == id) {

            // 先更新账号基础表中的用户名。
            boolean updated = service.update()
                    .set("username", vo.getUsername())
                    .eq("id", id)
                    .update();

            // 再更新详情资料表；不存在记录时自动插入。
            boolean detailsSaved = this.saveOrUpdate(
                    new AccountDetails(id, vo.getGender(), vo.getPhone(), vo.getQq(), vo.getWx(), vo.getDesc())
            );

            return updated && detailsSaved;
        }
        return false;
    }
}

package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.dto.Account;
import com.example.entity.vo.request.ConfirmResetVO;
import com.example.entity.vo.request.EmailRegisterVO;
import com.example.entity.vo.request.EmailResetVO;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 账户领域服务接口，负责登录用户加载、注册、找回密码等核心能力。
 */
public interface AccountService extends IService<Account>, UserDetailsService {
    /**
     * 根据用户名或邮箱查询账户。
     */
    Account findAccountByNameOrEmail(String text);
    /**
     * 发送邮箱验证码（注册/重置密码）。
     */
    String registerEmailVerifyCode(String type, String email, String address);
    /**
     * 使用邮箱验证码完成注册。
     */
    String registerEmailAccount(EmailRegisterVO info);
    /**
     * 使用邮箱验证码重置账户密码。
     */
    String resetEmailAccountPassword(EmailResetVO info);
    /**
     * 校验重置密码验证码是否正确。
     */
    String resetConfirm(ConfirmResetVO info);
}

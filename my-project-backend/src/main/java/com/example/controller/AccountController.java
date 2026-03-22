package com.example.controller;

import com.example.entity.RestBean;
import com.example.entity.dto.Account;
import com.example.entity.dto.AccountDetails;
import com.example.entity.dto.AccountPrivacy;
import com.example.entity.vo.request.ChangePasswordVO;
import com.example.entity.vo.request.DetailsSaveVO;
import com.example.entity.vo.request.ModifyEmailVO;
import com.example.entity.vo.request.PrivacySaveVO;
import com.example.entity.vo.response.AccountDetailsVO;
import com.example.entity.vo.response.AccountPrivacyVO;
import com.example.entity.vo.response.AccountVO;
import com.example.service.AccountDetailsService;
import com.example.service.AccountPrivacyService;
import com.example.service.AccountService;
import com.example.utils.Const;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
/**
 * 用户中心接口，负责当前登录用户的资料与隐私配置。
 */
public class AccountController {

    /**
     * 账号基础信息服务。
     */
    @Resource
    AccountService accountService;

    /**
     * 详情资料服务。
     */
    @Resource
    AccountDetailsService accountDetailsService;

    /**
     * 隐私配置服务。
     */
    @Resource
    AccountPrivacyService accountPrivacyService;

    /**
     * 查询当前用户基础账号信息。
     */
    @GetMapping("/info")
    public RestBean<AccountVO> findAccountById(@RequestAttribute(Const.ATTR_USER_ID) int id){
        Account account = accountService.findAccountById(id);
        return account == null ? RestBean.failure(401, "用户信息请求失败") : RestBean.success(account.asViewObject(AccountVO.class));
    }

    /**
     * 查询当前用户详情资料；若未初始化则返回空对象视图。
     */
    @GetMapping("/details")
    public RestBean<AccountDetailsVO> details(@RequestAttribute(Const.ATTR_USER_ID) int id){
        AccountDetails details = Optional
                .ofNullable(accountDetailsService.findAccountDetailsById(id))
                .orElseGet((AccountDetails::new));
        return RestBean.success(details.asViewObject(AccountDetailsVO.class));
    }

    /**
     * 保存当前用户详情资料。
     */
    @PostMapping("/save-details")
    public RestBean<Void> saveDetails(@RequestAttribute(Const.ATTR_USER_ID) int id,
                                      @RequestBody @Validated DetailsSaveVO vo){
        boolean success = accountDetailsService.saveAccountDetails(id, vo);
        return success ? RestBean.success() : RestBean.failure(400, "此用户名已被其他用户使用，请重新更换！");
    }

    /**
     * 修改当前用户绑定邮箱。
     */
    @PostMapping("/modify-email")
    public RestBean<Void> modifyEmail(@RequestAttribute(Const.ATTR_USER_ID) int id,
                                      @RequestBody @Validated ModifyEmailVO vo){
        String result = accountService.modifyEmail(id, vo);
        return result == null ? RestBean.success() : RestBean.failure(400, result);
    }

    /**
     * 修改当前用户登录密码。
     */
    @PostMapping("/change-password")
    public RestBean<Void> changePassword(@RequestAttribute(Const.ATTR_USER_ID) int id,
                                        @RequestBody @Validated ChangePasswordVO vo){
            String result = accountService.changePassword(id, vo);
            return result == null ? RestBean.success() : RestBean.failure(400, result);
    }

    /**
     * 保存当前用户单项隐私开关。
     */
    @PostMapping("/save-privacy")
    public RestBean<Void> savePrivacy(@RequestAttribute(Const.ATTR_USER_ID) int id,
                                      @RequestBody @Validated PrivacySaveVO vo){
        accountPrivacyService.savePrivacy(id, vo);
        return RestBean.success();
    }

    /**
     * 查询当前用户隐私配置；若不存在则返回默认值。
     */
    @GetMapping("/privacy")
    public RestBean<AccountPrivacyVO> privacy(@RequestAttribute(Const.ATTR_USER_ID) int id){
        return RestBean.success(accountPrivacyService.accountPrivacy(id).asViewObject(AccountPrivacyVO.class));
    }
}

package com.example.controller;

import com.example.entity.RestBean;
import com.example.entity.dto.Account;
import com.example.entity.dto.AccountDetails;
import com.example.entity.vo.request.ChangePasswordVO;
import com.example.entity.vo.request.DetailsSaveVO;
import com.example.entity.vo.request.ModifyEmailVO;
import com.example.entity.vo.response.AccountDetailsVO;
import com.example.entity.vo.response.AccountVO;
import com.example.service.AccountDetailsService;
import com.example.service.AccountService;
import com.example.utils.Const;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class AccountController {

    @Resource
    AccountService accountService;

    @Resource
    AccountDetailsService accountDetailsService;

    @GetMapping("/info")
    public RestBean<AccountVO> findAccountById(@RequestAttribute(Const.ATTR_USER_ID) int id){
        Account account = accountService.findAccountById(id);
        return account == null ? RestBean.failure(401, "用户信息请求失败") : RestBean.success(account.asViewObject(AccountVO.class));
    }

    @GetMapping("/details")
    public RestBean<AccountDetailsVO> details(@RequestAttribute(Const.ATTR_USER_ID) int id){
        AccountDetails details = Optional
                .ofNullable(accountDetailsService.findAccountDetailsById(id))
                .orElseGet((AccountDetails::new));
        return RestBean.success(details.asViewObject(AccountDetailsVO.class));
    }

    @PostMapping("/save-details")
    public RestBean<Void> saveDetails(@RequestAttribute(Const.ATTR_USER_ID) int id,
                                      @RequestBody @Validated DetailsSaveVO vo){
        boolean success = accountDetailsService.saveAccountDetails(id, vo);
        return success ? RestBean.success() : RestBean.failure(400, "此用户名已被其他用户使用，请重新更换！");
    }

    @PostMapping("/modify-email")
    public RestBean<Void> modifyEmail(@RequestAttribute(Const.ATTR_USER_ID) int id,
                                      @RequestBody @Validated ModifyEmailVO vo){
        String result = accountService.modifyEmail(id, vo);
        return result == null ? RestBean.success() : RestBean.failure(400, result);
    }

    @PostMapping("/change-password")
    public RestBean<Void> changePassword(@RequestAttribute(Const.ATTR_USER_ID) int id,
                                        @RequestBody @Validated ChangePasswordVO vo){
            String result = accountService.changePassword(id, vo);
            return result == null ? RestBean.success() : RestBean.failure(400, result);
    }
}

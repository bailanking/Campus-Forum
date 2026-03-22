package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.dto.AccountPrivacy;
import com.example.entity.vo.request.PrivacySaveVO;

/**
 * 用户隐私配置服务，负责隐私开关的读取与更新。
 */
public interface AccountPrivacyService extends IService<AccountPrivacy> {
    /**
     * 按字段类型更新当前用户某一项隐私开关。
     */
    void savePrivacy(int id, PrivacySaveVO vo);

    /**
     * 查询当前用户隐私配置，不存在时返回默认配置对象。
     */
    AccountPrivacy accountPrivacy(int id);
}

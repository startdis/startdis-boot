package com.startdis.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.domain.model.entity.UserField;
import com.startdis.infra.mapper.UserFieldMapper;
import com.startdis.server.service.UserFieldService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 用户字段表 UserFieldService
 */
@Service("userFieldService")
public class UserFieldServiceImpl extends ServiceImpl<UserFieldMapper, UserField> implements UserFieldService {

}

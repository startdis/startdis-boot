package com.startdis.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.domain.model.entity.UserGroup;
import com.startdis.infra.mapper.UserGroupMapper;
import com.startdis.server.service.UserGroupService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 用户分组表 UserGroupService
 */
@Service("userGroupService")
public class UserGroupServiceImpl extends ServiceImpl<UserGroupMapper, UserGroup> implements UserGroupService {

}

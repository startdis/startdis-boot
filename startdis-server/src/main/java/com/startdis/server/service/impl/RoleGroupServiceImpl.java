package com.startdis.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.domain.model.entity.RoleGroup;
import com.startdis.infra.mapper.RoleGroupMapper;
import com.startdis.server.service.RoleGroupService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 角色分组表 RoleGroupService
 */
@Service("roleGroupService")
public class RoleGroupServiceImpl extends ServiceImpl<RoleGroupMapper, RoleGroup> implements RoleGroupService {

}

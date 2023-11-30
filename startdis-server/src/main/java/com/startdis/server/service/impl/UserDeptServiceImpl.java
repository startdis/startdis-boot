package com.startdis.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.domain.model.entity.UserDept;
import com.startdis.infra.mapper.UserDeptMapper;
import com.startdis.server.service.UserDeptService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 用户部门表(UserDept)服务实现层
 */
@Service("userDeptService")
public class UserDeptServiceImpl extends ServiceImpl<UserDeptMapper, UserDept> implements UserDeptService {

}


package com.startdis.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.domain.model.entity.Group;
import com.startdis.infra.mapper.GroupMapper;
import com.startdis.server.service.GroupService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 分组表 GroupService
 */
@Service("groupService")
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupService {

}

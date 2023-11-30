package com.startdis.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.domain.model.entity.GroupMenu;
import com.startdis.infra.mapper.GroupMenuMapper;
import com.startdis.server.service.GroupMenuService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 分组菜单表 GroupMenuService
 */
@Service("groupMenuService")
public class GroupMenuServiceImpl extends ServiceImpl<GroupMenuMapper, GroupMenu> implements GroupMenuService {

}

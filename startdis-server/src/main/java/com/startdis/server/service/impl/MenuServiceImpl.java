package com.startdis.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.domain.model.entity.Menu;
import com.startdis.infra.mapper.MenuMapper;
import com.startdis.server.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 菜单表 MenuService
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}

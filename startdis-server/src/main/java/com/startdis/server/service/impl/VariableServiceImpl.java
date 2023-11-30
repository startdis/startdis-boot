package com.startdis.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.domain.model.entity.Variable;
import com.startdis.infra.mapper.VariableMapper;
import com.startdis.server.service.VariableService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 全局变量表(Variable)服务实现层
 */
@Service("variableService")
public class VariableServiceImpl extends ServiceImpl<VariableMapper, Variable> implements VariableService {

}


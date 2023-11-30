package com.startdis.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.domain.model.entity.OperateLog;
import com.startdis.infra.mapper.OperateLogMapper;
import com.startdis.server.service.OperateLogService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 操作日志记录表 OperateLogService
 */
@Service("operateLogService")
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLog> implements OperateLogService {

}

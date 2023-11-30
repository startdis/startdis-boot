package com.startdis.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.domain.model.entity.SensitiveWord;
import com.startdis.infra.mapper.SensitiveWordMapper;
import com.startdis.server.service.SensitiveWordService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 系统敏感词表 SensitiveWordService
 */
@Service("sensitiveWordService")
public class SensitiveWordServiceImpl extends ServiceImpl<SensitiveWordMapper, SensitiveWord>
        implements SensitiveWordService {
    
}

package com.startdis.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.domain.model.entity.Company;
import com.startdis.infra.mapper.CompanyMapper;
import com.startdis.server.service.CompanyService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 公司表 CompanyService
 */
@Service("companyService")
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

}

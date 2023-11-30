package com.startdis.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.domain.model.entity.Variable;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 全局变量表(Variable)数据层
 */
@Mapper
public interface VariableMapper extends BaseMapper<Variable> {

}

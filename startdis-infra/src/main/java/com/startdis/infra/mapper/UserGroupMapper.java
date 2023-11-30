package com.startdis.infra.mapper;


import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.domain.model.entity.UserGroup;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 用户分组表 UserGroupMapper
 */
@Mapper
public interface UserGroupMapper extends BaseMapper<UserGroup> {
    
    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserGroup> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserGroup> entities);
    
    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserGroup> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UserGroup> entities);
    
}

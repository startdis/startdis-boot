package com.startdis.infra.mapper;


import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.domain.model.entity.Post;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 岗位表 PostMapper
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {
    
    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Post> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Post> entities);
    
    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Post> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Post> entities);
    
}

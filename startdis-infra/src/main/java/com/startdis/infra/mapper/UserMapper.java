package com.startdis.infra.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.domain.model.entity.User;
import com.startdis.domain.model.query.UserQuery;
import com.startdis.domain.model.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 用户表 UserMapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    
    /**
     * 分页查询用户列表接口
     */
    List<UserVO> listPage(@Param("item") UserQuery userQuery);
    int countPage(@Param("item") UserQuery userQuery);
    
    
    
}

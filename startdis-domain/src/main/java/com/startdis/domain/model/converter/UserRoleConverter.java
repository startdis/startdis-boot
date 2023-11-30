package com.startdis.domain.model.converter;


import com.startdis.domain.model.dto.post.UserRolePostDTO;
import com.startdis.domain.model.dto.put.UserRolePutDTO;
import com.startdis.domain.model.entity.UserRole;
import com.startdis.domain.model.query.UserRoleQuery;
import com.startdis.domain.model.vo.UserRoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**

 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 用户角色表 UserRoleConverter转换接口
 */
@Mapper
public interface UserRoleConverter {

    public static UserRoleConverter INSTANT = Mappers.getMapper(UserRoleConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserRole postDtoToEntity(UserRolePostDTO userRoleDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserRole putDtoToEntity(UserRolePutDTO userRoleDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserRole queryToEntity(UserRoleQuery userRoleQuery);
    
    UserRoleVO entityToVO(UserRole userRole);
    
}

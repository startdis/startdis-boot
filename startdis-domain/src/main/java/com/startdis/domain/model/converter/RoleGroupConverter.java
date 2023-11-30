package com.startdis.domain.model.converter;


import com.startdis.domain.model.dto.post.RoleGroupPostDTO;
import com.startdis.domain.model.dto.put.RoleGroupPutDTO;
import com.startdis.domain.model.entity.RoleGroup;
import com.startdis.domain.model.query.RoleGroupQuery;
import com.startdis.domain.model.vo.RoleGroupVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**

 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 角色分组表 RoleGroupConverter转换接口
 */
@Mapper
public interface RoleGroupConverter {

    public static RoleGroupConverter INSTANT = Mappers.getMapper(RoleGroupConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RoleGroup postDtoToEntity(RoleGroupPostDTO roleGroupDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RoleGroup putDtoToEntity(RoleGroupPutDTO roleGroupDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RoleGroup queryToEntity(RoleGroupQuery roleGroupQuery);
    
    RoleGroupVO entityToVO(RoleGroup roleGroup);
    
}

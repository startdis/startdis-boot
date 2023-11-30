package com.startdis.domain.model.converter;


import com.startdis.domain.model.dto.post.VariablePostDTO;
import com.startdis.domain.model.dto.put.VariablePutDTO;
import com.startdis.domain.model.entity.Variable;
import com.startdis.domain.model.query.VariableQuery;
import com.startdis.domain.model.vo.VariableVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**

 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 全局变量表 VariableConverter转换接口
 */
@Mapper
public interface VariableConverter {

    public static VariableConverter INSTANT = Mappers.getMapper(VariableConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Variable postDtoToEntity(VariablePostDTO variableDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Variable putDtoToEntity(VariablePutDTO variableDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Variable queryToEntity(VariableQuery variableQuery);
    
    VariableVO entityToVO(Variable variable);
    
}

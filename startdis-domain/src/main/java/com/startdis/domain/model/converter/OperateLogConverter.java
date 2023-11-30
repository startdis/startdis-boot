package com.startdis.domain.model.converter;


import com.startdis.domain.model.dto.post.OperateLogPostDTO;
import com.startdis.domain.model.dto.put.OperateLogPutDTO;
import com.startdis.domain.model.entity.OperateLog;
import com.startdis.domain.model.query.OperateLogQuery;
import com.startdis.domain.model.vo.OperateLogVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**

 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 操作日志记录表 OperateLogConverter转换接口
 */
@Mapper
public interface OperateLogConverter {

    public static OperateLogConverter INSTANT = Mappers.getMapper(OperateLogConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    OperateLog postDtoToEntity(OperateLogPostDTO operateLogDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    OperateLog putDtoToEntity(OperateLogPutDTO operateLogDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    OperateLog queryToEntity(OperateLogQuery operateLogQuery);
    
    OperateLogVO entityToVO(OperateLog operateLog);
    
}

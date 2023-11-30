package com.startdis.domain.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.startdis.comm.domain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 角色分组表 RoleGroupDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sd_role_group")
public class RoleGroup extends BaseEntity {
    
    
    /**
     * 角色ID
     */
    private String roleId;
    
    /**
     * 角色编码
     */
    private String rolerCode;
    
    /**
     * 分组ID
     */
    private String groupId;
    
    /**
     * 分组编码
     */
    private String groupCode;
    
    /**
     * 显示顺序
     */
    private Integer sort;
    
    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;
    
    
}

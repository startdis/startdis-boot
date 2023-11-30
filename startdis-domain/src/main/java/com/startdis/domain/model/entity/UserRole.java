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
 * @desc 用户角色表 UserRoleDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sd_user_role")
public class UserRole extends BaseEntity {
    
    
    /**
     * 用户ID
     */
    private String userId;
    
    /**
     * 角色ID
     */
    private String roleId;
    
    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;
    
    
}

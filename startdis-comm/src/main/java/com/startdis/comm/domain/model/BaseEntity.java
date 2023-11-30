package com.startdis.comm.domain.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Startdis
 * @email startdis@yundingshuzi.cn
 * @desc BaseEntity
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 乐观锁
     */
    @Version
    @TableField("revision")
    private Integer revision;

    /**
     * 逻辑删除 （0正常 1删除）
     * value = ""  默认的原值，默认为 0；
     * delval = "" 删除后的值，默认为1；
     */
    //@TableLogic(value="0",delval="1")
    @TableField("deleted")
    private Integer deleted;
    
    /**
     * 集团租户ID
     */
    @TableField("group_tenant_id")
    private String groupTenantId;

    /**
     * 公司租户ID
     */
    @TableField("company_tenant_id")
    private String companyTenantId;

    /**
     * 创建人
     */
    @TableField("created_by")
    private String createdBy;

    /**
     * 创建时间
     */
    //@TableField(value = "created_at", fill = FieldFill.INSERT)
    @TableField("created_at")
    private LocalDateTime createdAt;

    /**
     * 更新人
     */
    @TableField("updated_by")
    private String updatedBy;

    /**
     * 更新时间
     */
    //@TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
    @TableField("updated_at")
    private LocalDateTime updatedAt;

}

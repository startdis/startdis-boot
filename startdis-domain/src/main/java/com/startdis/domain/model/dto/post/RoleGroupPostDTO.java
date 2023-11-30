package com.startdis.domain.model.dto.post;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 角色分组表 RoleGroupDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "角色分组表")
public class RoleGroupPostDTO implements Serializable {
    
    private static final long serialVersionUID = 614155210513625714L;
    
    
    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    private String roleId;
    
    /**
     * 角色编码
     */
    @ApiModelProperty("角色编码")
    private String rolerCode;
    
    /**
     * 分组ID
     */
    @ApiModelProperty("分组ID")
    private String groupId;
    
    /**
     * 分组编码
     */
    @ApiModelProperty("分组编码")
    private String groupCode;
    
    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer sort;
    
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    
    
}

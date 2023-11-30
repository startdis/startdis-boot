package com.startdis.domain.model.query;


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
 * @desc 分组菜单表 GroupMenuQuery对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "分组菜单表")
public class GroupMenuQuery implements Serializable {
    
    private static final long serialVersionUID = -96326843328410895L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 分组ID
     */
    @ApiModelProperty("分组ID")
    private String groupId;
    
    /**
     * 菜单ID
     */
    @ApiModelProperty("菜单ID")
    private String menuId;
    
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    
}


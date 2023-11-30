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
 * @desc 用户分组表 UserGroupDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "用户分组表")
public class UserGroupPostDTO implements Serializable {
    
    private static final long serialVersionUID = 299903818165478478L;
    
    
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String userId;
    
    /**
     * 用户编码
     */
    @ApiModelProperty("用户编码")
    private String userCode;
    
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

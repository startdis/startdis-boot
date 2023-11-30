package com.startdis.domain.model.dto.put;


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
 * @desc 系统敏感词表 SensitiveWordDTO对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel(description = "系统敏感词表")
public class SensitiveWordPutDTO implements Serializable {
    
    private static final long serialVersionUID = -23286663136948796L;
    
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private String id;
    
    /**
     * 敏感词
     */
    @ApiModelProperty("敏感词")
    private String wordName;
    
    /**
     * 敏感词标签
     */
    @ApiModelProperty("敏感词标签")
    private String wordTags;
    
    /**
     * 敏感词描述
     */
    @ApiModelProperty("敏感词描述")
    private String wordRemark;
    
    /**
     * 是否启用（0停用 1启用）
     */
    @ApiModelProperty("是否启用（0停用 1启用）")
    private Integer status;
    
    
}

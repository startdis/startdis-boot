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
 * @desc 分组表 GroupDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sd_group")
public class Group extends BaseEntity {
    
    
    /**
     * 分组编码
     */
    private String groupCode;
    
    /**
     * 分组名称
     */
    private String groupName;
    
    /**
     * 分组描述
     */
    private String groupRemark;
    
    /**
     * 显示顺序
     */
    private Integer groupSort;
    
    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;
    
    
}

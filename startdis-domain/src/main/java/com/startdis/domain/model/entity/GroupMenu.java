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
 * @desc 分组菜单表 GroupMenuDTO对象
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sd_group_menu")
public class GroupMenu extends BaseEntity {
    
    
    /**
     * 分组ID
     */
    private String groupId;
    
    /**
     * 菜单ID
     */
    private String menuId;
    
    /**
     * 是否启用（0停用 1启用）
     */
    private Integer status;
    
    
}

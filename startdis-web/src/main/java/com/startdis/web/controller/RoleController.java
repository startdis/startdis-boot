package com.startdis.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.kits.bean.BeanCopyKits;
import com.startdis.domain.model.converter.RoleConverter;
import com.startdis.domain.model.dto.post.RolePostDTO;
import com.startdis.domain.model.dto.put.RolePutDTO;
import com.startdis.domain.model.entity.Role;
import com.startdis.domain.model.entity.UserRole;
import com.startdis.domain.model.query.RoleQuery;
import com.startdis.domain.model.vo.RoleVO;
import com.startdis.server.service.RoleService;
import com.startdis.server.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 角色表(Role)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Role", tags = {"角色表"})
@RequestMapping("role")
public class RoleController {
    
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;
    
    @Resource
    private UserRoleService userRoleService;
    
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    public ResultBean<RoleVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Role role = roleService.getById(id);
        //处理格式转换
        RoleVO roleVO = RoleConverter.INSTANT.entityToVO(role);
        return ResultBean.success(roleVO);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param roleQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<RoleVO>> list(@RequestBody RoleQuery roleQuery) {
        //处理格式转换
        Role role = RoleConverter.INSTANT.queryToEntity(roleQuery);
        //执行分页查询
        List<Role> listResult = roleService.list(new QueryWrapper<>(role));
        return ResultBean.success(BeanCopyKits.coverList(listResult, RoleVO.class));
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param roleQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<RoleVO>> page(PageQuery pageQuery, RoleQuery roleQuery) {
        //处理分页条件
        Page<Role> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Role role = RoleConverter.INSTANT.queryToEntity(roleQuery);
        //执行分页查询
        Page<Role> pageResult = roleService.page(page, new QueryWrapper<>(role));
        PagerBean<RoleVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                BeanCopyKits.coverList(pageResult.getRecords(), RoleVO.class));
        return ResultBean.success(pageBean);
    }
    
    /**
     * 新增数据
     *
     * @param roleDTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated RolePostDTO roleDTO) {
        //处理格式转换
        Role role = RoleConverter.INSTANT.postDtoToEntity(roleDTO);
        //执行数据保存
        return ResultBean.success(roleService.save(role));
    }
    
    /**
     * 修改数据
     *
     * @param roleDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated RolePutDTO roleDTO) {
        //处理格式转换
        Role role = RoleConverter.INSTANT.putDtoToEntity(roleDTO);
        //执行数据更新
        return ResultBean.success(roleService.updateById(role));
    }
    
    /**
     * 删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @ApiOperation("删除数据")
    public ResultBean<Boolean> delete(@RequestParam("ids") List<String> ids) {
        for (String id : ids) {
            //删除用户角色信息
            LambdaQueryWrapper<UserRole> userRoleQueryWrapper = Wrappers.lambdaQuery(UserRole.class).eq(UserRole::getRoleId, id);
            userRoleService.remove(userRoleQueryWrapper);
        }
        //删除角色信息
        roleService.removeByIds(ids);
        return ResultBean.success();
    }
    
}


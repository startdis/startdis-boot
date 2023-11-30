package com.startdis.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.domain.model.converter.GroupConverter;
import com.startdis.domain.model.dto.post.GroupPostDTO;
import com.startdis.domain.model.dto.put.GroupPutDTO;
import com.startdis.domain.model.entity.Group;
import com.startdis.domain.model.query.GroupQuery;
import com.startdis.domain.model.vo.GroupVO;
import com.startdis.server.service.GroupService;
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
 * @desc 分组表(Group)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Group", tags = {"分组表"})
@RequestMapping("group")
public class GroupController {
    
    /**
     * 服务对象
     */
    @Resource
    private GroupService groupService;
    
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    public ResultBean<GroupVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Group group = groupService.getById(id);
        //处理格式转换
        GroupVO groupVO = GroupConverter.INSTANT.entityToVO(group);
        return ResultBean.success(groupVO);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param groupQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<GroupVO>> list(@RequestBody GroupQuery groupQuery) {
        //处理格式转换
        Group group = GroupConverter.INSTANT.queryToEntity(groupQuery);
        //执行分页查询
        List<Group> listResult = groupService.list(new QueryWrapper<>(group));
        return ResultBean.success(BeanCopyKits.coverList(listResult, GroupVO.class));
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery  分页对象
     * @param groupQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<GroupVO>> page(PageQuery pageQuery, GroupQuery groupQuery) {
        //处理分页条件
        Page<Group> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Group group = GroupConverter.INSTANT.queryToEntity(groupQuery);
        //执行分页查询
        Page<Group> pageResult = groupService.page(page, new QueryWrapper<>(group));
        PagerBean<GroupVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                BeanCopyKits.coverList(pageResult.getRecords(), GroupVO.class));
        return ResultBean.success(pageBean);
    }
    
    /**
     * 新增数据
     *
     * @param groupDTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated GroupPostDTO groupDTO) {
        //处理格式转换
        Group group = GroupConverter.INSTANT.postDtoToEntity(groupDTO);
        //执行数据保存
        return ResultBean.success(groupService.save(group));
    }
    
    /**
     * 修改数据
     *
     * @param groupDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated GroupPutDTO groupDTO) {
        //处理格式转换
        Group group = GroupConverter.INSTANT.putDtoToEntity(groupDTO);
        //执行数据更新
        return ResultBean.success(groupService.updateById(group));
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
        return ResultBean.success(groupService.removeByIds(ids));
    }
    
}


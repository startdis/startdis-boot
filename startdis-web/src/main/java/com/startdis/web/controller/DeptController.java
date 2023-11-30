package com.startdis.web.controller;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.bean.TreeBuild;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.comm.util.config.SnowflakeConfig;
import com.startdis.comm.util.object.ObjectKits;
import com.startdis.domain.model.converter.DeptConverter;
import com.startdis.domain.model.dto.post.DeptPostDTO;
import com.startdis.domain.model.dto.put.DeptPutDTO;
import com.startdis.domain.model.entity.Dept;
import com.startdis.domain.model.entity.UserDept;
import com.startdis.domain.model.query.DeptQuery;
import com.startdis.domain.model.tree.DeptTree;
import com.startdis.domain.model.vo.DeptVO;
import com.startdis.server.service.DeptService;
import com.startdis.server.service.UserDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 部门表(Dept)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Dept", tags = {"部门表"})
@RequestMapping("dept")
public class DeptController {
    
    /**
     * 服务对象
     */
    @Resource
    private DeptService deptService;
    
    @Resource
    private UserDeptService userDeptService;
    
    /**
     * 雪花ID生成
     */
    @Resource
    private SnowflakeConfig snowflakeConfig;
    
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    public ResultBean<DeptVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Dept dept = deptService.getById(id);
        //处理格式转换
        DeptVO deptVO = DeptConverter.INSTANT.entityToVO(dept);
        return ResultBean.success(deptVO);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param deptQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/tree")
    @ApiOperation("查询树结构")
    public ResultBean<List<DeptTree>> tree(@RequestBody DeptQuery deptQuery) {
        Dept dept = DeptConverter.INSTANT.queryToEntity(deptQuery);
        List<Dept> listResult = deptService.list(new QueryWrapper<>(dept));
        // 原查询结果转换树形结构
        List<DeptTree> deptTrees = BeanCopyKits.coverList(listResult, DeptTree.class);
        
        //查询条件为空，默认查询根结点为0的一级部门
        if (ObjectKits.isEmpty(deptQuery) && CollectionUtil.isNotEmpty(deptTrees)) {
            String rootId = "0";
            // 创建树形结构并返回
            TreeBuild treeBuild = new TreeBuild(rootId, deptTrees);
            return ResultBean.success(treeBuild.buildTree());
        }
        return ResultBean.success(deptTrees);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param deptQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<DeptVO>> list(@RequestBody DeptQuery deptQuery) {
        //处理格式转换
        Dept dept = DeptConverter.INSTANT.queryToEntity(deptQuery);
        //执行分页查询
        List<Dept> listResult = deptService.list(new QueryWrapper<>(dept));
        return ResultBean.success(BeanCopyKits.coverList(listResult, DeptVO.class));
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param deptQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<DeptVO>> page(PageQuery pageQuery, DeptQuery deptQuery) {
        //处理分页条件
        Page<Dept> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Dept dept = DeptConverter.INSTANT.queryToEntity(deptQuery);
        //执行分页查询
        Page<Dept> pageResult = deptService.page(page, new QueryWrapper<>(dept));
        PagerBean<DeptVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                BeanCopyKits.coverList(pageResult.getRecords(), DeptVO.class));
        return ResultBean.success(pageBean);
    }
    
    /**
     * 新增数据
     *
     * @param deptDTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    //@Transactional(rollbackFor = Exception.class,transactionManager = "transactionManager")
    public ResultBean<Boolean> insert(@RequestBody @Validated DeptPostDTO deptDTO) {
        //新增部门信息
        Dept dept = DeptConverter.INSTANT.postDtoToEntity(deptDTO);
        return ResultBean.success(deptService.save(dept));
    }
    
    /**
     * 修改数据
     *
     * @param deptDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated DeptPutDTO deptDTO) {
        //更新部门信息
        Dept dept = DeptConverter.INSTANT.putDtoToEntity(deptDTO);
        return ResultBean.success(deptService.updateById(dept));
    }
    
    /**
     * 删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @ApiOperation("删除数据")
    @Transactional(rollbackFor = Exception.class,transactionManager = "transactionManager")
    public ResultBean<Boolean> delete(@RequestParam("ids") List<String> ids) {
        for (String id : ids) {
            //删除用户部门信息
            LambdaQueryWrapper<UserDept> userDeptQueryWrapper = Wrappers.lambdaQuery(UserDept.class).eq(UserDept::getDeptId, id);
            userDeptService.remove(userDeptQueryWrapper);
        }
        //删除部门信息
        deptService.removeByIds(ids);
        return ResultBean.success("删除数据成功！");
    }
    
}


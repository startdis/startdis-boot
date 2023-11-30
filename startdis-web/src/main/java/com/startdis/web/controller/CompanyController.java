package com.startdis.web.controller;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.bean.TreeBuild;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.kits.bean.BeanCopyKits;
import com.startdis.comm.kits.config.SnowflakeConfig;
import com.startdis.comm.kits.object.ObjectKits;
import com.startdis.domain.model.converter.CompanyConverter;
import com.startdis.domain.model.dto.post.CompanyPostDTO;
import com.startdis.domain.model.dto.put.CompanyPutDTO;
import com.startdis.domain.model.entity.Company;
import com.startdis.domain.model.query.CompanyQuery;
import com.startdis.domain.model.tree.CompanyTree;
import com.startdis.domain.model.vo.CompanyVO;
import com.startdis.server.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 公司表(Company)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Company", tags = {"公司表"})
@RequestMapping("company")
public class CompanyController {
    
    /**
     * 服务对象
     */
    @Resource
    private CompanyService companyService;
    
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
    public ResultBean<CompanyVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Company company = companyService.getById(id);
        //处理格式转换
        CompanyVO companyVO = CompanyConverter.INSTANT.entityToVO(company);
        return ResultBean.success(companyVO);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param companyQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/tree")
    @ApiOperation("查询树结构")
    public ResultBean<List<CompanyTree>> tree(@RequestBody CompanyQuery companyQuery) {
        Company company = CompanyConverter.INSTANT.queryToEntity(companyQuery);
        List<Company> listResult = companyService.list(new QueryWrapper<>(company));
        // 原查询结果转换树形结构
        List<CompanyTree> companyTrees = BeanCopyKits.coverList(listResult, CompanyTree.class);
        // TODO 后续从全局变量中取出租户信息，判断集团租户和公司租户是否是同一个值，如果是说明当前登陆的集团账户，此时公司根结点ID为0，否则公司根结点ID为当前用户登陆的公司ID
        if (ObjectKits.isEmpty(companyQuery) && CollectionUtil.isNotEmpty(companyTrees)) {
            String rootId = "0";
            // 创建树形结构并返回
            TreeBuild treeBuild = new TreeBuild(rootId, companyTrees);
            return ResultBean.success(treeBuild.buildTree());
        }
        return ResultBean.success(companyTrees);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param companyQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<CompanyVO>> list(@RequestBody CompanyQuery companyQuery) {
        Company company = CompanyConverter.INSTANT.queryToEntity(companyQuery);
        List<Company> listResult = companyService.list(new QueryWrapper<>(company));
        return ResultBean.success(BeanCopyKits.coverList(listResult, CompanyVO.class));
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery    分页对象
     * @param companyQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<CompanyVO>> page(PageQuery pageQuery, CompanyQuery companyQuery) {
        //处理分页条件
        Page<Company> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Company company = CompanyConverter.INSTANT.queryToEntity(companyQuery);
        //执行分页查询
        Page<Company> pageResult = companyService.page(page, new QueryWrapper<>(company));
        PagerBean<CompanyVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                BeanCopyKits.coverList(pageResult.getRecords(), CompanyVO.class));
        return ResultBean.success(pageBean);
    }
    
    /**
     * 新增数据
     *
     * @param companyDTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    @Transactional(rollbackFor = Exception.class,transactionManager = "transactionManager")
    public ResultBean<Boolean> insert(@RequestBody @Validated CompanyPostDTO companyDTO) {
        //新增公司数据
        Company company = CompanyConverter.INSTANT.postDtoToEntity(companyDTO);
        return ResultBean.success(companyService.save(company));
    }
    
    /**
     * 修改数据
     *
     * @param companyDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    @Transactional(rollbackFor = Exception.class,transactionManager = "transactionManager")
    public ResultBean<Boolean> update(@RequestBody @Validated CompanyPutDTO companyDTO) {
        //更新公司数据
        Company company = CompanyConverter.INSTANT.putDtoToEntity(companyDTO);
        return ResultBean.success(companyService.updateById(company));
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
        //删除公司数据
        return ResultBean.success(companyService.removeByIds(ids));
    }
    
}


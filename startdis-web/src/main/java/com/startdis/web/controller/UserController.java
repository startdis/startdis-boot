package com.startdis.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.comm.util.config.SnowflakeConfig;
import com.startdis.domain.model.converter.UserConverter;
import com.startdis.domain.model.dto.post.UserPostDTO;
import com.startdis.domain.model.dto.put.UserPutDTO;
import com.startdis.domain.model.entity.User;
import com.startdis.domain.model.query.UserQuery;
import com.startdis.domain.model.vo.UserVO;
import com.startdis.server.service.UserService;
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
 * @desc 用户表(User)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "User", tags = {"用户表"})
@RequestMapping("user")
public class UserController {
    
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    
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
    public ResultBean<UserVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        User user = userService.getById(id);
        //处理格式转换
        UserVO userVO = UserConverter.INSTANT.entityToVO(user);
        //组装用户信息
        userService.assembleUserVO(userVO);
        return ResultBean.success(userVO);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param userQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<UserVO>> list(@RequestBody UserQuery userQuery) {
        //处理格式转换
        User user = UserConverter.INSTANT.queryToEntity(userQuery);
        //执行分页查询
        List<User> listResult = userService.list(new QueryWrapper<>(user));
        List<UserVO> userVOS = BeanCopyKits.coverList(listResult, UserVO.class);
        //组装用户中间表信息
        for (UserVO userVO : userVOS) {
            userService.assembleUserVO(userVO);
        }
        return ResultBean.success(userVOS);
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param userQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<UserVO>> page(PageQuery pageQuery, UserQuery userQuery) {
        //支持部门、岗位、角色搜索
        PagerBean<UserVO> pageBean =userService.listPage(pageQuery,userQuery);
        return ResultBean.success(pageBean);
    }
    
    /**
     * 新增数据
     *
     * @param userDTO 实体对象
     * @return 新增结果 用户关系表
     */
    @PostMapping()
    @ApiOperation("新增数据")
    @Transactional(rollbackFor = Exception.class, transactionManager = "transactionManager")
    public ResultBean<Boolean> insert(@RequestBody @Validated UserPostDTO userDTO) {
        //处理格式转换
        User user = UserConverter.INSTANT.postDtoToEntity(userDTO);
        //保存用户数据
        String userId = snowflakeConfig.nextIdStr();
        user.setId(userId);
        userService.save(user);
        //保存用户中间表数据
        userService.saveUserRelation(userDTO, userId);
        return ResultBean.success("新增数据成功！");
    }

    /**
     * 修改数据
     *
     * @param userDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    @Transactional(rollbackFor = Exception.class, transactionManager = "transactionManager")
    public ResultBean<Boolean> update(@RequestBody @Validated UserPutDTO userDTO) {
        //处理格式转换
        User user = UserConverter.INSTANT.putDtoToEntity(userDTO);
        //执行数据更新
        userService.updateById(user);
        //更新用户中间表数据
        userService.updateUserRelation(userDTO);
        return ResultBean.success("更新数据成功！");
    }

    /**
     * 删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @ApiOperation("删除数据")
    @Transactional(rollbackFor = Exception.class, transactionManager = "transactionManager")
    public ResultBean<Boolean> delete(@RequestParam("ids") List<String> ids) {
        //删除用户信息
        userService.removeByIds(ids);
        //删除用户中间表数据
        userService.deleteUserRelation(ids);
        return ResultBean.success("删除数据成功！");
    }

}


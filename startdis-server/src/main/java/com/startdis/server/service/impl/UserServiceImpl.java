package com.startdis.server.service.impl;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.domain.model.dto.post.UserPostDTO;
import com.startdis.domain.model.dto.put.UserPutDTO;
import com.startdis.domain.model.entity.*;
import com.startdis.domain.model.query.UserQuery;
import com.startdis.domain.model.vo.UserVO;
import com.startdis.infra.mapper.UserMapper;
import com.startdis.server.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 用户表 UserService
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    
    @Resource
    private UserMapper userMapper;
    @Resource
    private DeptService deptService;

    @Resource
    private PostService postService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserDeptService userDeptService;

    @Resource
    private UserPostService userPostService;

    @Resource
    private UserRoleService userRoleService;

    /**
     * 保存用户中间表数据
     * @param userDTO
     */
    @Override
    public void saveUserRelation(UserPostDTO userDTO, String userId) {
        //保存用户部门信息
        if (StringUtils.isNotBlank(userDTO.getDeptId())) {
            userDeptService.save(UserDept.builder().userId(userId).deptId(userDTO.getDeptId()).build());
        }
        //保存用户岗位信息
        if (StringUtils.isNotBlank(userDTO.getPostId())) {
            userPostService.save(UserPost.builder().userId(userId).postId(userDTO.getPostId()).build());
        }
        //保存用户角色信息
        if (StringUtils.isNotBlank(userDTO.getRoleId())) {
            userRoleService.save(UserRole.builder().userId(userId).roleId(userDTO.getRoleId()).build());
        }
    }

    /**
     * 更新用户中间表数据
     * @param userDTO
     */
    @Override
    public void updateUserRelation(UserPutDTO userDTO) {
        //更新用户部门信息（先删除后新增）
        if (StringUtils.isNotBlank(userDTO.getDeptId())) {
            LambdaQueryWrapper<UserDept> userDeptQueryWrapper = Wrappers.lambdaQuery(UserDept.class).eq(UserDept::getUserId, userDTO.getId());
            userDeptService.remove(userDeptQueryWrapper);
            userDeptService.save(UserDept.builder().userId(userDTO.getId()).deptId(userDTO.getDeptId()).build());
        }
        //更新用户岗位信息（先删除后新增）
        if (StringUtils.isNotBlank(userDTO.getPostId())) {
            LambdaQueryWrapper<UserPost> userPostQueryWrapper = Wrappers.lambdaQuery(UserPost.class).eq(UserPost::getUserId, userDTO.getId());
            userPostService.remove(userPostQueryWrapper);
            userPostService.save(UserPost.builder().userId(userDTO.getId()).postId(userDTO.getPostId()).build());
        }
        //更新用户角色信息（先删除后新增）
        if (StringUtils.isNotBlank(userDTO.getRoleId())) {
            LambdaQueryWrapper<UserRole> userRoleQueryWrapper = Wrappers.lambdaQuery(UserRole.class).eq(UserRole::getUserId, userDTO.getId());
            userRoleService.remove(userRoleQueryWrapper);
            userRoleService.save(UserRole.builder().userId(userDTO.getId()).roleId(userDTO.getRoleId()).build());
        }
    }

    /**
     * 删除用户中间表数据
     * @param ids
     */
    @Override
    public void deleteUserRelation(List<String> ids) {
        for (String id : ids) {
            //删除用户部门信息
            LambdaQueryWrapper<UserDept> userDeptQueryWrapper = Wrappers.lambdaQuery(UserDept.class).eq(UserDept::getUserId, id);
            userDeptService.remove(userDeptQueryWrapper);
            //删除用户岗位信息
            LambdaQueryWrapper<UserPost> userPostQueryWrapper = Wrappers.lambdaQuery(UserPost.class).eq(UserPost::getUserId, id);
            userPostService.remove(userPostQueryWrapper);
            //删除用户角色信息
            LambdaQueryWrapper<UserRole> userRoleQueryWrapper = Wrappers.lambdaQuery(UserRole.class).eq(UserRole::getUserId, id);
            userRoleService.remove(userRoleQueryWrapper);
        }
    }

    /**
     * 组装用户中间表数据
     * @param userVO
     */
    @Override
    public void assembleUserVO(UserVO userVO) {
        //组装用户部门信息
        LambdaQueryWrapper<UserDept> userDeptQueryWrapper = Wrappers.lambdaQuery(UserDept.class).eq(UserDept::getUserId, userVO.getId());
        List<UserDept> userDepts = userDeptService.list(userDeptQueryWrapper);
        if (CollectionUtil.isNotEmpty(userDepts)) {
            Set<String> deptIds = userDepts.stream().map(UserDept::getDeptId).collect(Collectors.toSet());
            LambdaQueryWrapper<Dept> deptQueryWrapper = Wrappers.lambdaQuery(Dept.class).in(Dept::getId, deptIds);
            List<Dept> list = deptService.list(deptQueryWrapper);
            userVO.setDeptId(list.get(0).getId());
            userVO.setDeptName(list.get(0).getDeptName());
        }
        //组装用户岗位信息
        LambdaQueryWrapper<UserPost> userPostQueryWrapper = Wrappers.lambdaQuery(UserPost.class).eq(UserPost::getUserId, userVO.getId());
        List<UserPost> userPosts = userPostService.list(userPostQueryWrapper);
        if (CollectionUtil.isNotEmpty(userPosts)) {
            Set<String> postIds = userPosts.stream().map(UserPost::getPostId).collect(Collectors.toSet());
            LambdaQueryWrapper<Post> postQueryWrapper = Wrappers.lambdaQuery(Post.class).in(Post::getId, postIds);
            List<Post> list = postService.list(postQueryWrapper);
            userVO.setPostId(list.get(0).getId());
            userVO.setPostName(list.get(0).getPostName());
        }
        //组装用户角色信息
        LambdaQueryWrapper<UserRole> userRoleQueryWrapper = Wrappers.lambdaQuery(UserRole.class).eq(UserRole::getUserId, userVO.getId());
        List<UserRole> userRoles = userRoleService.list(userRoleQueryWrapper);
        if (CollectionUtil.isNotEmpty(userRoles)) {
            Set<String> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toSet());
            LambdaQueryWrapper<Role> roleQueryWrapper = Wrappers.lambdaQuery(Role.class).in(Role::getId, roleIds);
            List<Role> list = roleService.list(roleQueryWrapper);
            userVO.setRoleId(list.get(0).getId());
            userVO.setRoleName(list.get(0).getRoleName());
        }
    }
    
    @Override
    public PagerBean<UserVO> listPage(PageQuery pageQuery, UserQuery userQuery) {
        Page<UserVO> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        Integer count = userMapper.countPage(userQuery);
        List<UserVO> userVOS = userMapper.listPage(userQuery);
        //组装用户中间表信息
        for (UserVO userVO : userVOS) {
            assembleUserVO(userVO);
        }
        PagerBean<UserVO> pageBean = new PagerBean<>(Long.valueOf(count), page.getCurrent(), page.getSize(), userVOS);
        return pageBean;
    }
    
}

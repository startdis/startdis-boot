package com.startdis.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.google.common.collect.ImmutableMap;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.comm.util.config.SnowflakeConfig;
import com.startdis.domain.model.converter.PostConverter;
import com.startdis.domain.model.dto.post.PostPostDTO;
import com.startdis.domain.model.dto.put.PostPutDTO;
import com.startdis.domain.model.entity.Post;
import com.startdis.domain.model.entity.UserPost;
import com.startdis.domain.model.query.PostQuery;
import com.startdis.domain.model.vo.PostVO;
import com.startdis.server.service.PostService;
import com.startdis.server.service.UserPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 岗位表(Post)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Post", tags = {"岗位表"})
@RequestMapping("post")
public class PostController {
    
    /**
     * 服务对象
     */
    @Resource
    private PostService postService;
    
    @Resource
    private UserPostService userPostService;
    
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
    public ResultBean<PostVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Post post = postService.getById(id);
        // 处理格式转换
        PostVO postVO = PostConverter.INSTANT.entityToVO(post);
        return ResultBean.success(postVO);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param postQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<PostVO>> list(@RequestBody PostQuery postQuery) {
        // 处理格式转换
        Post post = PostConverter.INSTANT.queryToEntity(postQuery);
        // 执行集合查询
        List<Post> listResult = postService.list(new QueryWrapper<>(post));
        return ResultBean.success(BeanCopyKits.coverList(listResult, PostVO.class));
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param postQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<PostVO>> page(PageQuery pageQuery, PostQuery postQuery) {
        // 处理分页条件
        Page<Post> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        Post post = PostConverter.INSTANT.queryToEntity(postQuery);
        // 执行分页查询
        Page<Post> pageResult = postService.page(page, new QueryWrapper<>(post));
        PagerBean<PostVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                BeanCopyKits.coverList(pageResult.getRecords(), PostVO.class));
        return ResultBean.success(pageBean);
    }
    
    /**
     * 新增数据
     *
     * @param postDTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    @Transactional(rollbackFor = Exception.class, transactionManager = "transactionManager")
    public ResultBean<Map<String, String>> insert(@RequestBody @Validated PostPostDTO postDTO) {
        // 保存岗位信息
        Post post = PostConverter.INSTANT.postDtoToEntity(postDTO);
        String postId = snowflakeConfig.nextIdStr();
        post.setId(postId);
        postService.save(post);
        return ResultBean.success("新增岗位成功", ImmutableMap.of("postId", postId));
    }
    
    /**
     * 修改数据
     *
     * @param postDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    @Transactional(rollbackFor = Exception.class, transactionManager = "transactionManager")
    public ResultBean<Boolean> update(@RequestBody @Validated PostPutDTO postDTO) {
        // 更新岗位信息
        Post post = PostConverter.INSTANT.putDtoToEntity(postDTO);
        return ResultBean.success(postService.updateById(post));
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
            // 删除用户岗位信息
            LambdaQueryWrapper<UserPost> userPostQueryWrapper = Wrappers.lambdaQuery(UserPost.class).eq(UserPost::getPostId, id);
            userPostService.remove(userPostQueryWrapper);
        }
        // 删除岗位信息
        postService.removeByIds(ids);
        return ResultBean.success("删除数据成功！");
    }
    
}

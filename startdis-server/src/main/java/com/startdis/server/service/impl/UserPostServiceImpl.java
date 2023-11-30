package com.startdis.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.domain.model.entity.UserPost;
import com.startdis.infra.mapper.UserPostMapper;
import com.startdis.server.service.UserPostService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 用户岗位表 UserPostService
 */
@Service("userPostService")
public class UserPostServiceImpl extends ServiceImpl<UserPostMapper, UserPost> implements UserPostService {

}

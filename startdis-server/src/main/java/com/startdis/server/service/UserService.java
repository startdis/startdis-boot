package com.startdis.server.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.domain.model.dto.post.UserPostDTO;
import com.startdis.domain.model.dto.put.UserPutDTO;
import com.startdis.domain.model.entity.User;
import com.startdis.domain.model.query.UserQuery;
import com.startdis.domain.model.vo.UserVO;

import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 用户表 UserService
 */
public interface UserService extends IService<User> {

    void saveUserRelation(UserPostDTO userDTO, String userId);

    void updateUserRelation(UserPutDTO userDTO);

    void deleteUserRelation(List<String> ids);

    void assembleUserVO(UserVO userVO);
    
    PagerBean<UserVO> listPage(PageQuery pageQuery,UserQuery userQuery);
}

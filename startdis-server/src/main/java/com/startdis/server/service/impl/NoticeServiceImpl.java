package com.startdis.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.domain.model.entity.Notice;
import com.startdis.infra.mapper.NoticeMapper;
import com.startdis.server.service.NoticeService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 通知公告表(Notice)服务实现层
 */
@Service("noticeService")
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

}


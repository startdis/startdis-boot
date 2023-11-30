package com.startdis.comm.domain.bean;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Startdis
 * @email startdis@yundingshuzi.cn
 * @desc PagerBean
 */
@Data
public class PagerBean<T> implements Serializable {
    
    private static final long serialVersionUID = 4804053559968742915L;
    
    /**
     * 总记录数
     */
    private Long total;
    
    /**
     * 当前页
     */
    protected Long pageNum;
    
    /**
     * 页大小
     */
    protected Long pageSize;
    
    /**
     * 列表数据
     */
    private List<?> records;
    
    public PagerBean() {
    }
    
    public PagerBean(Long total, Long pageNum, Long pageSize, List<T> records) {
        this.total = total;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.records = records;
    }
}

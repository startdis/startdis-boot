package com.startdis.comm.jdbc.handler;

import java.util.List;

/**
 * @author Startdis
 * @email startdis@yundingshuzi.cn
 * @desc List类型转换器
 */
public class ListTypeHandler extends JsonTypeHandler<List> {
    public ListTypeHandler() {
        super(List.class);
    }
}

package com.startdis.comm.domain.model;

/**
 * @Author: zlt
 */
public enum CodeEnum {
    SUCCESS(200),
    ERROR(400);

    private Integer code;
    CodeEnum(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}

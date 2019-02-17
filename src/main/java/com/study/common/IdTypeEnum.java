package com.study.common;

/**
 * @author pengwei.tan
 * @version 1.8
 * @date 2019/1/31 14:16
 */
public enum IdTypeEnum {
    ID_TYPE01("01","身份证"),
    ID_TYPE02("02","护照"),
    ID_TYPE03("03","港澳通行证"),
    ID_TYPE04("03","其他");


    private String type;
    private String typeDesc;

    IdTypeEnum(String type, String typeDesc) {
        this.type = type;
        this.typeDesc = typeDesc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }}

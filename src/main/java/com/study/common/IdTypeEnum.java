package com.study.common;

import org.apache.commons.lang3.StringUtils;

/**
 * @author pengwei.tan
 * @version 1.8
 * @date 2019/1/31 14:16
 */

public enum IdTypeEnum {
    ID_TYPE01("01","身份证"),
    ID_TYPE02("02","护照"),
    ID_TYPE03("03","港澳通行证"),
    ID_TYPE04("04","其他");


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
    }

    public static String getDescByType(String type){
        String desc =null;
        for (IdTypeEnum idTypeEnum : IdTypeEnum.values()) {
            if(StringUtils.equals(type,idTypeEnum.getType())){
                desc = idTypeEnum.getTypeDesc();
            }
        }
        return desc;
    }

    public static String getTypeByDesc(String typeDesc){
        String type =null;
        for (IdTypeEnum idTypeEnum : IdTypeEnum.values()) {
            if(StringUtils.equals(typeDesc,idTypeEnum.getTypeDesc())){
                type = idTypeEnum.getType();
            }
        }
        return type;
    }
}
package com.study.mapper;

import com.study.po.Local;

public interface LocalMapper {
    int deleteByPrimaryKey(String localId);

    int insert(Local record);

    int insertSelective(Local record);

    Local selectByPrimaryKey(String localId);

    int updateByPrimaryKeySelective(Local record);

    int updateByPrimaryKey(Local record);
}
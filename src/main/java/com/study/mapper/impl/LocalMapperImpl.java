package com.study.mapper.impl;

import com.study.mapper.LocalMapper;
import com.study.mapper.UserMapper;
import com.study.po.Local;
import com.study.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LocalMapperImpl extends LocalMapper {

    List<Local> queryProv();

    List<Local> queryCity(@Param("provId") String provId);

    List<Local> queryArea(@Param("cityId") String cityId);


}
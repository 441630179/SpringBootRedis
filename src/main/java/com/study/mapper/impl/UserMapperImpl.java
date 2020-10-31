package com.study.mapper.impl;

import com.study.mapper.BankMapper;
import com.study.mapper.UserMapper;
import com.study.po.Bank;
import com.study.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapperImpl extends UserMapper {

    List<User> selectAll(User user);

    int batchDel(Long[] ids);

    int insertList(List<User> users);
}
package com.study.service;

import com.study.mapper.impl.UserMapperImpl;
import com.study.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUser implements ServiceUpload<List<User>> {
    @Autowired
    private UserMapperImpl userMapperImpl;

    public int addUser(User user){
        int count =userMapperImpl.insertSelective(user);
        return count;
    }

    public List<User> userList(User user){
        List<User> list = userMapperImpl.selectAll(user);
        return list;
    }

    public int userUpdate(User user){
        int count = userMapperImpl.updateByPrimaryKeySelective(user);
        return count;
    }

    public int userDel(Long id){
        int count = userMapperImpl.deleteByPrimaryKey(id);
        return count;
    }

    public int userbatchDel(Long[]  ids){
        int count = userMapperImpl.batchDel(ids);
        return count;
    }



    @Override
    public int saveData(List<User> users) {
        return  userMapperImpl.insertList(users);
    }
}

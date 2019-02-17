package com.study.service;

import com.study.mapper.impl.BankMapperImpl;
import com.study.po.Bank;
import com.study.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceJSON {
    @Autowired
    private BankMapperImpl bankMapperImpl;

    public List<Bank> selectBankAll(){
        return bankMapperImpl.selectAll();
    }

    public Bank selectBankById(Long id){
        return bankMapperImpl.selectByPrimaryKey(id);
    }

    public List<Bank> selectByName(String bankName){
        return bankMapperImpl.selectBankByName(bankName);
    }
}

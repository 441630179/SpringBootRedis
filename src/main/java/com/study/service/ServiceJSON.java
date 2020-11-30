package com.study.service;

import com.study.mapper.impl.BankMapperImpl;
import com.study.po.Bank;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceJSON {

    @Autowired
    private BankMapperImpl bankMapperImpl;

    public List<Bank> selectBankAll() {
        return bankMapperImpl.selectAll();
    }

    public Bank selectBankById(Long id) {
        return bankMapperImpl.selectByPrimaryKey(id);
    }

    public List<Bank> selectByName(String bankName) {
        return bankMapperImpl.selectBankByName(bankName);
    }
}

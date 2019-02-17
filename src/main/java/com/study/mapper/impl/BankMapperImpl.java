package com.study.mapper.impl;

import com.study.mapper.BankMapper;
import com.study.po.Bank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BankMapperImpl extends BankMapper {
    List<Bank> selectAll ();

    List<Bank> selectBankByName (@Param("bankName") String bankName);
}
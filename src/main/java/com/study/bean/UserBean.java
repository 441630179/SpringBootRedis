package com.study.bean;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

@Data
public class UserBean {
    @ExcelIgnore
    private Long id;

    @ExcelProperty("用户名称")
    private String userName;

    @ExcelProperty("用户密码")
    private String userPassword;

    @ExcelProperty(value="证件类型",converter = UserConvert.class)
    private String idType;

    @ExcelProperty("证件号码")
    private String idNo;

    @ExcelProperty("证件邮箱")
    private String userEmail;

    @ExcelProperty("用户手机号")
    private String userPhone;

    @ExcelProperty("开始日期")
    private String begDate;

    @ExcelProperty("结束日期")
    private String endDate;

}

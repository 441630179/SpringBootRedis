package com.study.bean;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserBean {

    @ExcelIgnore
    private Long id;

    @ExcelProperty("用户名称")
    @NotBlank(message = "用户名称不能为空")
    private String userName;

    @NotBlank
    @Length(min = 8, max = 16, message = "密码长度不合法")
    @ExcelProperty("用户密码")
    private String userPassword;

    @NotBlank(message = "证件类型")
    @ExcelProperty(value = "证件类型", converter = UserConvert.class)
    private String idType;

    @NotBlank(message = "证件号码不能为空")
    @ExcelProperty("证件号码")
    private String idNo;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式非法")
    @ExcelProperty("证件邮箱")
    private String userEmail;

    @NotBlank(message = "手机号不能为空")
    @ExcelProperty("用户手机号")
    private String userPhone;

    @NotBlank
    @ExcelProperty("开始日期")
    private String begDate;

    @NotBlank
    @ExcelProperty("结束日期")
    private String endDate;

}

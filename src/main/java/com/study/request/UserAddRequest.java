package com.study.request;

import com.study.Utils.PatternConstant;
import com.study.annotation.CheckPhoneNum;
import com.study.annotation.ChineseLength;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@ApiModel
public class UserAddRequest {
    @ApiModelProperty(value = "用户名称",required = true)
    @NotBlank(message = "用户名不能为空")
    @ChineseLength(max = 8,message = "用户名不能超过8个字节")
    private String userName;

    @ApiModelProperty(value = "用户密码",required = true)
    @NotBlank(message = "密码不能为空")
    @Length(min = 8,max = 16)
    private String userPassword;

    @ApiModelProperty(value = "证件类型",required = true,example = "01,02,03,04")
    @Pattern(regexp= PatternConstant.ID_TYPE_PATTERN)
    private String idType;

    @ApiModelProperty(value = "证件号码",required = true)
    @NotBlank(message = "证件号码不能为空")
    private String idNo;

    @ApiModelProperty(value = "用户邮箱",required = true)
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String userEmail;

    @ApiModelProperty(value = "手机号",required = true)
    @NotBlank(message = "手机号不能为空")
    @CheckPhoneNum(message = "手机号格式非法")
    private String userPhone;

    @ApiModelProperty(value = "有效期开始日期",required = true,dataType = "日期")
    @NotBlank(message = "开始日期不能为空")
    private String begDate;

    @ApiModelProperty(value = "有效期结束日期",required = true)
    @NotBlank(message = "结束日期不能为空")
    private String endDate;

}

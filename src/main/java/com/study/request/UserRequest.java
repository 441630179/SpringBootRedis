package com.study.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserRequest{
    @ApiModelProperty(value = "用户编号",required = true)
    private Long id;

    @ApiModelProperty(value = "用户名称",required = true)
    private String userName;

    @ApiModelProperty(value = "用户密码",required = true)
    private String userPassword;

    @ApiModelProperty(value = "证件类型",required = true)
    private String idType;

    @ApiModelProperty(value = "证件号码",required = true)
    private String idNo;

    @ApiModelProperty(value = "用户邮箱",required = true)
    private String userEmail;

    @ApiModelProperty(value = "用户手机号",required = true)
    private String userPhone;

    private String page;

    private String size;
}

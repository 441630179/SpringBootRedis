package com.study.controller;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.Utils.ValidateUtils;
import com.study.bean.UserBean;
import com.study.common.Constans;
import com.study.common.IdTypeEnum;
import com.study.exception.BizException;
import com.study.listener.ExcelListener;
import com.study.po.User;
import com.study.request.UserAddRequest;
import com.study.request.UserRequest;
import com.study.service.SerivceRocketProducer;
import com.study.service.ServiceUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api("ControllerUser的api")
@Controller
@Slf4j
public class  ControllerUser extends ControllerBase {
    @Autowired
    private ServiceUser serviceUser;

    @Autowired
    private SerivceRocketProducer serivceRocketProducer;


    @RequestMapping(value = "/user/userAddHtml")
    public String userAddHtml(Model model){
        model.addAttribute("idTypes", IdTypeEnum.values());
        return "user/userAdd";
    }


    @RequestMapping(value = "/user/userSeeHtml")
    public String userSeeHtml(Model model){
        model.addAttribute("idTypes", IdTypeEnum.values());
        return "user/userSee";
    }

    @ApiOperation(value = "用户添加",notes = "用户添加",httpMethod = "POST")
    @RequestMapping(value = "/user/userAdd")
    @ResponseBody
    public Map<String,String> userAdd(UserAddRequest userAddRequest){
        userAddRequest.setBegDate(userAddRequest.getBegDate().replaceAll("-",""));
        userAddRequest.setEndDate(userAddRequest.getEndDate().replaceAll("-",""));
        ValidateUtils.validateEntity(userAddRequest);
        User user = new User();
        BeanUtils.copyProperties(userAddRequest,user);
        int count = serviceUser.addUser(user);
        if(count !=1){
            throw new BizException("000094","新增用户失败");
        }
        return successMap("新增成功");
    }

    @ApiOperation(value = "用户列表查询",notes = "用户列表查询",httpMethod = "POST")
    @RequestMapping(value = "/user/userList")
    @ResponseBody
    public Map<String,Object>  userList(UserRequest userRequest){
        String page = StringUtils.defaultIfBlank(userRequest.getPage(),"1");
        String size = StringUtils.defaultIfBlank(userRequest.getSize(),"5");
        PageHelper.startPage(Integer.valueOf(page),Integer.valueOf(size));
        User user = new User();
        BeanUtils.copyProperties(userRequest,user);
        List<User> list= serviceUser.userList(user);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",pageInfo.getTotal());
        return map;
    }

    @ApiOperation(value = "用户更新",notes = "用户更新",httpMethod = "POST")
    @RequestMapping(value = "/user/userUpdate")
    @ResponseBody
    public Map<String,String>  userUpdate(UserRequest userRequest){
        Map<String,Object> map = new HashMap<>();

        User user = new User();
        BeanUtils.copyProperties(userRequest,user);

        int count = serviceUser.userUpdate(user);
        if(count!=1){
            return  failMap("000099","修改失败");
        }


        return successMap("修改成功");
    }

    @RequestMapping(value = "/user/userListHtml")
    public String userListHtml(Model model){
        model.addAttribute("idTypes", IdTypeEnum.values());
        return "user/userList";
    }

    @ApiOperation(value = "用户删除",notes = "用户删除",httpMethod = "POST")
    @RequestMapping(value = "/user/userDel")
    @ResponseBody
    public Map<String,String> userdel(@ApiParam(name = "id",value = "用户号",required = true) String id){
        Map<String,Object> map = new HashMap<>();
        int count = serviceUser.userDel(Long.valueOf(id));

        if(count!=1){
            return failMap("000093","删除失败");
        }

        return successMap("删除成功");
    }

    @ApiOperation(value = "用户批量删除",notes = "用户批量删除",httpMethod = "POST")
    @RequestMapping(value = "/user/userBatchDel")
    @ResponseBody
    public Map<String,String> userBatchDel(@ApiParam(name = "reqIds",value = "删除的批量用户号",required = true,example = "1,2,3,4") String reqIds){

        String[] tempIds= StringUtils.split(reqIds,",");

        Long[] ids = new Long[tempIds.length];

        for (int i = 0; i <tempIds.length ; i++) {
            ids[i]= Long.valueOf(tempIds[i]);
        }

        Map<String,Object> map = new HashMap<>();
        int count = serviceUser.userbatchDel(ids);

        if(count<1){

           return failMap("000099","删除失败");
        }
        return successMap("修改成功");
    }

    @ApiOperation(value = "用户下载",notes = "用户下载",httpMethod = "POST")
    @RequestMapping(value = "/user/userDownFile")
    @ResponseBody
    public Map<String,Object> userBatchDel(UserRequest userRequest){
        serivceRocketProducer.sendMessage("USER_DOMN_FILE_TOPIC",userRequest);

        Map<String,Object> map = new HashMap<>();
        map.put(Constans.RERUN_CODE,"000000");
        map.put(Constans.RERUN_MSG,"修改成功");
        return map;
    }


    @ApiOperation(value = "用户批量导入",notes = "用户批量导入",httpMethod = "POST")
    @RequestMapping(value = "/user/userBatchImport")
    @ResponseBody
    public Map<String,String> userBatchImport(MultipartFile userFile) throws IOException {
        EasyExcel.read(userFile.getInputStream(), UserBean.class, new ExcelListener(serviceUser)).sheet().doRead();
        return  successMap("批量导入成功");
    }

}

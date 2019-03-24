package com.study.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.common.Constans;
import com.study.common.IdTypeEnum;
import com.study.po.User;
import com.study.request.UserRequest;
import com.study.service.ServiceUser;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ControllerUser {
    private static final Logger logger = LoggerFactory.getLogger(ControllerUser.class);
    @Autowired
    private ServiceUser serviceUser;
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

    @RequestMapping(value = "/user/userAdd")
    public String userAdd(Model model, User user){
        user.setBegDate(user.getBegDate().replaceAll("-",""));
        user.setEndDate(user.getEndDate().replaceAll("-",""));
        int count = serviceUser.addUser(user);
        if(count !=1){
            logger.error("新增用户失败，用户名："+user.getUserName());
            return "user/fail";
        }

        return "/user/userList";
    }

    @RequestMapping(value = "/user/userList")
    @ResponseBody
    public Map<String,Object>  userList(Model model, UserRequest userRequest){
        ModelAndView modelAndView = new ModelAndView();
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

    @RequestMapping(value = "/user/userUpdate")
    @ResponseBody
    public Map<String,Object>  userUpdate(Model model, UserRequest userRequest){
        Map<String,Object> map = new HashMap<>();

        User user = new User();
        BeanUtils.copyProperties(userRequest,user);

        int count = serviceUser.userUpdate(user);
        if(count!=1){
            map.put(Constans.RERUN_CODE,"000099");
            map.put(Constans.RERUN_MSG,"修改失败");
        }

        map.put("returnCode","000000");
        map.put("returnMsg","修改成功");
        return map;
    }

    @RequestMapping(value = "/user/userListHtml")
    public String userListHtml(Model model){
        model.addAttribute("idTypes", IdTypeEnum.values());
        return "user/userList";
    }


    @RequestMapping(value = "/user/userDel")
    @ResponseBody
    public Map<String,Object> userdel(Model model, UserRequest userRequest){
        Map<String,Object> map = new HashMap<>();
        int count = serviceUser.userDel(userRequest.getId());

        if(count!=1){
            map.put(Constans.RERUN_CODE,"000099");
            map.put(Constans.RERUN_MSG,"删除失败");
        }

        map.put(Constans.RERUN_CODE,"000000");
        map.put(Constans.RERUN_MSG,"删除成功");
        return map;
    }

    @RequestMapping(value = "/user/userBatchDel")
    @ResponseBody
    public Map<String,Object> userBatchDel(HttpServletRequest request){

        String[] tempIds= StringUtils.split(request.getParameter("ids"),",");

        Long[] ids = new Long[tempIds.length];

        for (int i = 0; i <tempIds.length ; i++) {
            ids[i]= Long.valueOf(tempIds[i]);
        }

        Map<String,Object> map = new HashMap<>();
        int count = serviceUser.userbatchDel(ids);

        if(count<1){
            map.put(Constans.RERUN_CODE,"000099");
            map.put(Constans.RERUN_MSG,"删除失败");
        }

        map.put(Constans.RERUN_CODE,"000000");
        map.put(Constans.RERUN_MSG,"修改成功");
        return map;
    }
}

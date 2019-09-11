package cn.train.controller;

import cn.train.enity.ContactInfo;
import cn.train.enity.UserInfo;
import cn.train.service.BackstageService;
import cn.train.service.UserService;
import cn.train.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BackstageController {
    @Autowired
    UserService userService;
    @Autowired
    BackstageService backstageService;
    @RequestMapping("/backstage/add_UserInfo")
    @ResponseBody
    public int  add_UserInfo(UserInfo userInfo){
        return userService.Userregsiter(userInfo);
    }
    @RequestMapping("/backstage/get_AllUser")
    @ResponseBody
    public List<UserInfo>get_AllUser(){
        return userService.Get_AllUser();
    }
    @RequestMapping("/backstage/del_user")
    @ResponseBody
    public boolean del_user(int  id){
        return backstageService.del_user(id);
    }
    @RequestMapping("/backstage/alter_UserInfo")
    @ResponseBody
    public boolean alter_UserInfo(UserInfo userInfo){
        return backstageService.alter_UserInfo(userInfo);
    }
    @RequestMapping("/backstage/select_contact")
    @ResponseBody
    public List<ContactInfo> select_contact(int  id){
        return backstageService.Get_AllContact(id);
    }
}

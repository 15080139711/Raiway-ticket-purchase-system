package cn.train.controller;

import cn.train.enity.UserInfo;
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
//    @RequestMapping
//    public List<UserInfo> getAllUserInfo(){
//        return null;
//    }
    @RequestMapping("/add_UserInfo")
    @ResponseBody
    public boolean add_UserInfo(UserInfo userInfo){
        return userService.Add_User(userInfo);
    }
    @RequestMapping("/get_AllUser")
    @ResponseBody
    public List<UserInfo>get_AllUser(){
        return userService.Get_AllUser();
    }
}

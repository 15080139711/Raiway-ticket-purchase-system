package cn.train.controller;


import cn.train.enity.ContactInfo;
import cn.train.enity.UserInfo;
import cn.train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/api/user/register")
    public int UserRegister(@RequestBody UserInfo userInfo){
        System.out.println(userInfo);
        return  userService.Userregsiter(userInfo);
    }

    @RequestMapping("/api/user/login")
    public UserInfo UserLogin(@RequestBody UserInfo userInfo){
        System.out.println(userInfo.getName());
        System.out.println(userInfo.getPassword());
        return userService.logincheck(userInfo);
    }

    @RequestMapping("/api/user/addcontact")
    public int AddContact(@RequestBody ContactInfo contactInfo){
        System.out.println(contactInfo);
        return userService.AddContact(contactInfo);
    }

    @RequestMapping("/api/user/getInfo")
    public UserInfo getUserInfo(@RequestBody UserInfo userInfo){
        System.out.println(userInfo.getId());
        return userService.getInfo(userInfo.getId());
    }

    @RequestMapping("/api/user/activation")
    public int UserActivate(@RequestBody UserInfo userInfo){
        System.out.println("激活请求邮箱：" + userInfo.getEmail() + "密码：" + userInfo.getPassword());
        return userService.UserActivate(userInfo);
    }

    @RequestMapping("/api/user/getCotactByUserid")
    public List<ContactInfo> getCotactByUserid(@RequestBody UserInfo userInfo){
        System.out.println("取常用联系人数据userid：" + userInfo.getId());
        return userService.getCotactByUserid(userInfo.getId());
    }
}

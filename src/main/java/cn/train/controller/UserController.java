package cn.train.controller;


import cn.train.enity.UserInfo;
import cn.train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/api/user/register")
    public int Userregister(@RequestBody UserInfo userInfo){
        System.out.println(userInfo);
        return  userService.Userregsiter(userInfo);
    }

    @RequestMapping("/api/user/login")
    public UserInfo UserLogin(@RequestBody UserInfo userInfo){
        System.out.println(userInfo.getName());
        System.out.println(userInfo.getPassword());
        return userService.logincheck(userInfo);
    }
}

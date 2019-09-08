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
    public  int Userregister(@RequestBody UserInfo userInfo){
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUsername("xiaoning");
//        userInfo.setTraveltype(1);
//        userInfo.setSex(1);
//        userInfo.setPhone("12159636363");
//        userInfo.setPassword("5956daind");
//        userInfo.setName("陈加旭");
//        userInfo.setIdnumber("371082199999993636");
//        userInfo.setEmail("69693636@163.com");
//        userInfo.setDiscountnumber(null);
        System.out.println(userInfo);
        return  userService.Userregsiter(userInfo);
    }

}

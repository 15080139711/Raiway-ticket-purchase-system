package cn.train.controller;

import cn.train.enity.ContactInfo;
import cn.train.enity.TrainInfo;
import cn.train.enity.TrainModel;
import cn.train.enity.UserInfo;
import cn.train.service.BackstageService;
import cn.train.service.UserService;
import cn.train.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public int add_UserInfo(UserInfo userInfo) {
        return userService.Userregsiter(userInfo);
    }

    @RequestMapping("/backstage/get_AllUser")
    @ResponseBody
    public List<UserInfo> get_AllUser() {
        return userService.Get_AllUser();
    }

    @RequestMapping("/backstage/del_user")
    @ResponseBody
    public boolean del_user(int id) {
        return backstageService.del_user(id);
    }

    @RequestMapping("/backstage/alter_UserInfo")
    @ResponseBody
    public boolean alter_UserInfo(UserInfo userInfo) {
        return backstageService.alter_UserInfo(userInfo);
    }
    @RequestMapping("/backstage/select_contact")
    @ResponseBody
    public List<ContactInfo> select_contact(int id) {
        return backstageService.Get_AllContact(id);
    }

    //车次信息管理部分
    @RequestMapping("/backstage/add_trainInfo")
    @ResponseBody   //添加一条车次信息
    public boolean add_trainInfo(TrainInfo trainInfo){
       return backstageService.add_trainInfo(trainInfo);
    }
    @RequestMapping("/backstage/alter_trainInfo")
    @ResponseBody   //修改一条车次信息
    public boolean alter_trainInfo(TrainInfo trainInfo){
        return backstageService.alter_train(trainInfo);
    }
    @RequestMapping("/backstage/del_trainInfo")
    @ResponseBody  //删除一条 车次 信息
    public boolean del_trainInfo(int id){
        backstageService.del_train(id);

        return true;
    }
    @RequestMapping("/backstage/get_trainInfo")
    @ResponseBody    //获取所有 车次
    public List<TrainInfo> get_trainInfo(){
        return backstageService.get_train();
    }

    //火车信息
    @RequestMapping("/backstage/add_train")
    @ResponseBody   //添加一辆 火车
    public boolean add_train(TrainModel trainModel){
        return backstageService.add_train(trainModel);
    }
    @RequestMapping("/backstage/get_trainmodel")
    @ResponseBody   //获取 所有 火车 的信息 id ，name
    public List<TrainModel> get_trainmodel(){
        return backstageService.get_trainmodel();
    }

}


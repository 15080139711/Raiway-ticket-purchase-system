package cn.train.service;

import cn.train.enity.ContactInfo;
import cn.train.enity.UserInfo;
import cn.train.mapper.ContactInfoMapper;
import cn.train.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    ContactInfoMapper contactInfoMapper;

    @Override
    public int Userregsiter(UserInfo userInfo) {
        int n = 0;

        int count = userInfoMapper.checkInfo(userInfo);
        if(count != 0){
            System.out.println("用户信息已被注册！");
            return -1;//用户信息已存在
        }else{
            System.out.println("用户信息可注册！");
        }

        userInfo.setStatus(1);
        //开始插入信息
        if(userInfoMapper.insert(userInfo) == 1){
            //获取用户id
            n = userInfoMapper.selectIdByidnumber(userInfo.getIdnumber());
            //插入常用联系人信息
            ContactInfo contactInfo = new ContactInfo();
            contactInfo.setUserid(n);
            contactInfo.setName(userInfo.getName());
            contactInfo.setEmail(userInfo.getEmail());
            contactInfo.setIdnumber(userInfo.getIdnumber());
            contactInfo.setPhone(userInfo.getPhone());
            contactInfo.setSex(userInfo.getSex());
            contactInfo.setTraveltype(userInfo.getTraveltype());
            contactInfo.setDiscountcard(userInfo.getDiscountnumber());
            if(contactInfoMapper.insert(contactInfo)==1) {
                System.out.println("联系人信息插入成功");
            }
            else{
                System.out.println("联系人信息插入出现错误！");
                return -2;
            }
        }else{
            System.out.println("用户id获取失败");
            return -2;
        }

        //发送激活邮件


        return n;
    }

    @Override
    public UserInfo logincheck(UserInfo userInfo) {

        UserInfo userInfo1 = userInfoMapper.checklogin(userInfo);
        System.out.println(userInfo1);
        return userInfo1;
    }

    @Override
    public boolean Add_User(UserInfo userInfo) {
        int result=userInfoMapper.insert(userInfo);
        if(result==1)
        return true;
        return false;
    }

    @Override
    public List<UserInfo> Get_AllUser() {
        return userInfoMapper.getAlluser();
    }

    @Override
    public int AddContact(ContactInfo contactInfo) {
        int m = contactInfoMapper.insert(contactInfo);
        System.out.println(m);
        return m;
    }

    @Override
    public UserInfo getInfo(int id) {
        UserInfo temp = userInfoMapper.selectByPrimaryKey(id);
        temp.setPassword(null);
        return temp;
    }


}

package cn.train.service;

import cn.train.enity.ContactInfo;
import cn.train.enity.UserInfo;
import cn.train.mapper.ContactInfoMapper;
import cn.train.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackstageServiceImpl implements BackstageService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    ContactInfoMapper contactInfoMapper;

    @Override
    public boolean alter_UserInfo(UserInfo userInfo) {
        //有bug ，可以绕开注册时的约束，也就是可以起相同信息。
        int result= userInfoMapper.updateByPrimaryKey(userInfo);
        if(result==0)return false;
        return true;
    }

    @Override
    public boolean del_user(int  id ) {
        int reslut =contactInfoMapper.selectByUserid(id);
        if(reslut!=0){
            contactInfoMapper.deleteByUserid(id);
        }
        userInfoMapper.deleteByPrimaryKey(id);
        return true;
        }
      public boolean test(int id){
          userInfoMapper.deleteByPrimaryKey(id);
          return true;
      }

    @Override
    public List<ContactInfo> Get_AllContact(int userid) {
        List<ContactInfo> list=contactInfoMapper.get_contact(userid);
        for(ContactInfo u:list){
            System.out.println(u);
        }
        return contactInfoMapper.get_contact(userid);
    }

}

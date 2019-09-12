package cn.train.service;

import cn.train.enity.ContactInfo;
import cn.train.enity.TrainInfo;
import cn.train.enity.TrainModel;
import cn.train.enity.UserInfo;
import cn.train.mapper.ContactInfoMapper;
import cn.train.mapper.TrainInfoMapper;
import cn.train.mapper.TrainModelMapper;
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
    @Autowired
    TrainModelMapper trainModelMapper1;
    @Autowired
    TrainInfoMapper trainInfoMapper;

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
    //列车信息管理部分
    @Override
    public boolean add_train(TrainModel trainInfo) {
        if(trainModelMapper1.insert(trainInfo)==1)return true;
        return false;
    }

    @Override  //修改 车次 信息
    public boolean alter_train(TrainInfo trainInfo) {
        return trainInfoMapper.updateByPrimaryKey(trainInfo)==1?true:false;
    }

    @Override
    public List<TrainInfo> get_train() {
        return trainInfoMapper.getAll();
    }

    @Override
    public List<TrainModel> get_trainmodel() {
        return trainModelMapper1.getAll();
    }

    @Override
    public boolean add_trainInfo(TrainInfo trainInfo) {
        if(trainInfoMapper.insert(trainInfo)==1)return  true;
        return false;
    }


}

package cn.train.service;

import cn.train.enity.ContactInfo;
import cn.train.enity.TrainInfo;
import cn.train.enity.TrainModel;
import cn.train.enity.UserInfo;

import java.util.List;

public interface BackstageService {
    public  boolean alter_UserInfo(UserInfo userInfo);
    public boolean del_user(int  id);
    public List<ContactInfo> Get_AllContact(int userid);

    public boolean add_train(TrainModel trainModel);
    public boolean alter_train(TrainInfo trainInfo);
    public List<TrainInfo> get_train();
    public List<TrainModel>get_trainmodel();
    public boolean add_trainInfo(TrainInfo trainInfo);
}

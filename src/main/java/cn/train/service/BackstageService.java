package cn.train.service;

import cn.train.enity.*;

import java.util.List;

public interface BackstageService {
    //运行图
    public List<MapTrainInfo>get_maptrain();
    public boolean add_running(MapTrainInfo mapTrainInfo);
    public boolean add_stopcity(MapStopInfo mapStopInfo);
    //用户
    public  boolean alter_UserInfo(UserInfo userInfo);
    public boolean del_user(int  id);
    public List<ContactInfo> Get_AllContact(int userid);
    //车次
    public boolean add_trainInfo(TrainInfo trainInfo);
    public boolean del_train(int id);
    public boolean alter_train(TrainInfo trainInfo);
    public List<TrainInfo> get_train();
    //火车
    public boolean add_train(TrainModel trainModel);
    public List<TrainModel>get_trainmodel();
}

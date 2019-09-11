package cn.train.service;

import cn.train.enity.ContactInfo;
import cn.train.enity.UserInfo;

import java.util.List;

public interface BackstageService {
    public  boolean alter_UserInfo(UserInfo userInfo);
    public boolean del_user(int  id);
    public List<ContactInfo> Get_AllContact(int userid);
}

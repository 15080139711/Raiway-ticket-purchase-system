package cn.train.service;

import cn.train.enity.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    int Userregsiter(UserInfo userInfo);

    UserInfo logincheck(UserInfo userInfo);
    boolean Add_User(UserInfo userInfo);
    List<UserInfo>Get_AllUser();
}

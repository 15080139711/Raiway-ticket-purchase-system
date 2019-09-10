package cn.train.service;

import cn.train.enity.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    int Userregsiter(UserInfo userInfo);

    UserInfo logincheck(UserInfo userInfo);
}

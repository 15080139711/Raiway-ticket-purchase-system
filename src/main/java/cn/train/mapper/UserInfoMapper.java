package cn.train.mapper;

import cn.train.enity.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    int checkInfo(UserInfo userInfo);

    int selectIdByidnumber(String string);

    UserInfo checklogin(UserInfo userInfo);
}
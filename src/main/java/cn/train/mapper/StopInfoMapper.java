package cn.train.mapper;

import cn.train.enity.StopInfo;

public interface StopInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StopInfo record);

    int insertSelective(StopInfo record);

    StopInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StopInfo record);

    int updateByPrimaryKey(StopInfo record);
}
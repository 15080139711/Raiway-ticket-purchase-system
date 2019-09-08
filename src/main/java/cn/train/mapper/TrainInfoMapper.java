package cn.train.mapper;

import cn.train.enity.TrainInfo;

public interface TrainInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainInfo record);

    int insertSelective(TrainInfo record);

    TrainInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainInfo record);

    int updateByPrimaryKey(TrainInfo record);
}
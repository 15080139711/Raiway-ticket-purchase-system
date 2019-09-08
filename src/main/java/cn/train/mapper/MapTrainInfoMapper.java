package cn.train.mapper;

import cn.train.enity.MapTrainInfo;

public interface MapTrainInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MapTrainInfo record);

    int insertSelective(MapTrainInfo record);

    MapTrainInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MapTrainInfo record);

    int updateByPrimaryKey(MapTrainInfo record);
}
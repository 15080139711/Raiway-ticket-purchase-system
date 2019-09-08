package cn.train.mapper;

import cn.train.enity.MapStopInfo;

public interface MapStopInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MapStopInfo record);

    int insertSelective(MapStopInfo record);

    MapStopInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MapStopInfo record);

    int updateByPrimaryKey(MapStopInfo record);
}
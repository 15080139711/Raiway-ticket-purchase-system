package cn.train.mapper;

import cn.train.enity.MapCityInfo;

public interface MapCityInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MapCityInfo record);

    int insertSelective(MapCityInfo record);

    MapCityInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MapCityInfo record);

    int updateByPrimaryKey(MapCityInfo record);
}
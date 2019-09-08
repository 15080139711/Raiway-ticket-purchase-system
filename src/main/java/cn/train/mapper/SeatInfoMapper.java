package cn.train.mapper;

import cn.train.enity.SeatInfo;

public interface SeatInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SeatInfo record);

    int insertSelective(SeatInfo record);

    SeatInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SeatInfo record);

    int updateByPrimaryKey(SeatInfo record);
}
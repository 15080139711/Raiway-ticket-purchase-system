package cn.train.mapper;

import cn.train.enity.MapStopInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface MapStopInfoMapper {
    int insert_H (MapStopInfo mapStopInfo);
    int deleteByPrimaryKey(Integer id);

    int insert(MapStopInfo record);

    int insertSelective(MapStopInfo record);

    MapStopInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MapStopInfo record);

    int updateByPrimaryKey(MapStopInfo record);
}
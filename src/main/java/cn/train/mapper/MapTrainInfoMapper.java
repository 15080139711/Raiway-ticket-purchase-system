package cn.train.mapper;

import cn.train.enity.MapTrainInfo;
import cn.train.enity.TrainInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapTrainInfoMapper {
    List<MapTrainInfo> getAll();

    int deleteByPrimaryKey(Integer id);

    int insert(MapTrainInfo record);

    int insertSelective(MapTrainInfo record);

    TrainInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MapTrainInfo record);

    int updateByPrimaryKey(MapTrainInfo record);
}
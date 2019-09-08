package cn.train.mapper;

import cn.train.enity.TrainModel;

public interface TrainModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrainModel record);

    int insertSelective(TrainModel record);

    TrainModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrainModel record);

    int updateByPrimaryKey(TrainModel record);
}
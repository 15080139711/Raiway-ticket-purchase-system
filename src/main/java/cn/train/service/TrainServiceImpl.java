package cn.train.service;

import cn.train.enity.MapTrainInfo;
import cn.train.enity.TrainModel;
import cn.train.mapper.CityInfoMapper;
import cn.train.mapper.MapTrainInfoMapper;
import cn.train.mapper.TrainModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    TrainModelMapper trainModelMapper;
    @Autowired
    CityInfoMapper cityInfoMapper;
    @Autowired
    MapTrainInfoMapper mapTrainInfoMapper;

    @Override
    public List<MapTrainInfo> getAllTrainInfo() {

        List<MapTrainInfo> list = mapTrainInfoMapper.getAll();
        for (int i=0;i< list.size();i++){
            list.get(i).setTrainModel(trainModelMapper.selectByPrimaryKey(list.get(i).getModelid()));
            list.get(i).setFirstcity(cityInfoMapper.selectByPrimaryKey(list.get(i).getFirststation()));
            list.get(i).setLastcity(cityInfoMapper.selectByPrimaryKey(list.get(i).getLaststation()));
        }
        return list;
    }

    @Override
    public int generateDateTrain(String date) {
        int result = 0;
        return result;
    }
}

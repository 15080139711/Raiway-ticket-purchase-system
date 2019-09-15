package cn.train.service;

import cn.train.enity.OrderInfo;
import cn.train.enity.SoldTicket;
import cn.train.enity.StopInfo;
import cn.train.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderInfoMapper orderInfoMapper;
    @Autowired
    SoldTicketMapper soldTicketMapper;
    @Autowired
    StopInfoMapper stopInfoMapper;
    @Autowired
    CityInfoMapper cityInfoMapper;
    @Autowired
    ContactInfoMapper contactInfoMapper;

    public List<OrderInfo> getTicketInfo(List<OrderInfo> result){
        for(int i=0;i<result.size();i++){
            //每个订单填充数据
            List<SoldTicket> temp = new ArrayList<SoldTicket>();
            temp = soldTicketMapper.selectByOrderid(result.get(i).getId());
            for (int j=0;j<temp.size();j++){
                //每张车票填充数据
                StopInfo m = stopInfoMapper.selectByPrimaryKey(temp.get(j).getTostopid());
                m.setCityInfo(cityInfoMapper.selectByPrimaryKey(m.getCityid()));
                StopInfo n = stopInfoMapper.selectByPrimaryKey(temp.get(j).getFromstopid());
                n.setCityInfo(cityInfoMapper.selectByPrimaryKey(n.getCityid()));
                temp.get(j).setTostop(m);
                temp.get(j).setFromstop(n);
                temp.get(j).setContactInfo(contactInfoMapper.selectByPrimaryKey(temp.get(j).getContactid()));
            }
            result.get(i).setTickets(temp);
        }
        return result;
    }

    @Override
    public List<OrderInfo> getAllOrderByuserid(int userid) {
        List<OrderInfo> result = new ArrayList<OrderInfo>();
        result = orderInfoMapper.getAllOrder(userid);
        result = getTicketInfo(result);
        return result;
    }

    @Override
    public List<OrderInfo> getUndoneOrder(int userid) {
        List<OrderInfo> result = new ArrayList<OrderInfo>();
        result = orderInfoMapper.getUndoneOrder(userid);
        result = getTicketInfo(result);
        return result;
    }

    @Override
    public List<OrderInfo> getUnusedOrder(int userid) {
        List<OrderInfo> result = new ArrayList<OrderInfo>();
        result = orderInfoMapper.getUnusedOrder(userid);
        result = getTicketInfo(result);
        return result;
    }

    @Override
    public List<OrderInfo> getHistoryOrder(int userid) {
        List<OrderInfo> result = new ArrayList<OrderInfo>();
        result = orderInfoMapper.getHistoryOrder(userid);
        result = getTicketInfo(result);
        return result;
    }
}

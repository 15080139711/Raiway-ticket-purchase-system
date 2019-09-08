package cn.train.mapper;

import cn.train.enity.SoldTicket;

public interface SoldTicketMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SoldTicket record);

    int insertSelective(SoldTicket record);

    SoldTicket selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SoldTicket record);

    int updateByPrimaryKey(SoldTicket record);
}
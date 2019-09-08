package cn.train.mapper;

import cn.train.enity.UnsoldTicket;

public interface UnsoldTicketMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UnsoldTicket record);

    int insertSelective(UnsoldTicket record);

    UnsoldTicket selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UnsoldTicket record);

    int updateByPrimaryKey(UnsoldTicket record);
}
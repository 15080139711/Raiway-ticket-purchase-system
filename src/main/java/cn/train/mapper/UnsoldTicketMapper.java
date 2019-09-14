package cn.train.mapper;

import cn.train.enity.UnsoldTicket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnsoldTicketMapper {
    List<UnsoldTicket>getAll();
    int deleteByPrimaryKey(Integer id);

    int insert(UnsoldTicket record);

    int insertSelective(UnsoldTicket record);

    UnsoldTicket selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UnsoldTicket record);

    int updateByPrimaryKey(UnsoldTicket record);

    List<UnsoldTicket> getUnsoldTicketByTrainid(int trainid);
}
package cn.train.service;

import cn.train.enity.Search;
import cn.train.enity.UnsoldTicket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {

    List<UnsoldTicket> SingleSearch(Search search);

}

package cn.train.controller;


import cn.train.enity.Search;
import cn.train.enity.UnsoldTicket;
import cn.train.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class traincontroller {

    @Autowired
    TicketService ticketService;

    @RequestMapping("/api/train/single")
    public List<UnsoldTicket> SingleSearch(@RequestBody Search search){
        return ticketService.SingleSearch(search);
    }

}

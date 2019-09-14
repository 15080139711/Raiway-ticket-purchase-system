package cn.train.controller;


import cn.train.enity.Search;
import cn.train.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @RequestMapping("/api/ticket/getUnsoldTicketNum")
    public int[] getUnsoldTicketNum(@RequestBody Search search){
        return ticketService.getUnsoldTicketNum(search);
    }

}

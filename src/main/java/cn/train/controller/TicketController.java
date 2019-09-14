package cn.train.controller;


import cn.train.enity.OrderInfo;
import cn.train.enity.Search;
import cn.train.enity.SoldTicket;
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

    @RequestMapping("/api/ticket/submitTicket")
    public OrderInfo submitTicket(@RequestBody SoldTicket soldTicket){
        System.out.println("车票提交请求：" + soldTicket);
        //返回null则当前座号不存在
        return ticketService.submitTicket(soldTicket);
    }

}

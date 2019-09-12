package cn.train.service;

import cn.train.enity.*;
import cn.train.mapper.CityInfoMapper;
import cn.train.mapper.MapCityInfoMapper;
import cn.train.mapper.StopInfoMapper;
import cn.train.mapper.TrainInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TrainInfoMapper trainInfoMapper;
    @Autowired
    StopInfoMapper stopInfoMapper;
    @Autowired
    CityInfoMapper cityInfoMapper;
    @Autowired
    MapCityInfoMapper mapCityInfoMapper;

    public float CalculatePrice(int[] path,int m,int n){
        System.out.println(path[0]+"-"+path[path.length-1]);
        System.out.println("开始计算价格...");
        float[] prices = new float[path.length-1];
        float price = 0;

        MapCityInfo mapCityInfo = new MapCityInfo();
        for(int i=m;i<n;i++){
            mapCityInfo.setCityid1(path[i]);
            mapCityInfo.setCityid2(path[i+1]);
            float tmp = mapCityInfoMapper.getPriceByCityid(mapCityInfo);
            System.out.println(tmp);
            price += tmp;
        }
        return price;
    }

    public String Calculatetime(String leave, String arrive){
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        String time = new String();
        try {
            Date lea = df.parse(leave);
            Date arr = df.parse(arrive);
            //相减得毫秒级时间差
            long diff = arr.getTime()-lea.getTime();
            //规格化
            long days = diff / (1000 * 60 * 60 * 24);

            long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
            long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
            time = hours + "时" + minutes + "分";
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        System.out.println("历时："+ time);
        return time;
    }


    @Override
    public List<UnsoldTicket> SingleSearch(Search search) {
        System.out.println("开始查询车次...");
        List<TrainInfo> temp = new ArrayList<TrainInfo>();
        String day = search.getDay1();
        temp = trainInfoMapper.getTrainByDay(day);
        System.out.println(temp);
        System.out.println("开始筛选车次...");
        for(int i = 0; i < temp.size(); i++){
            List<StopInfo> tmp = stopInfoMapper.getStopByTrainid(temp.get(i).getId());
            System.out.println(tmp);
            int m1 = 0,m2 = 0;
            boolean n1 = false,n2 = false;
            for(int j = 0; j < tmp.size(); j++){
                if(tmp.get(j).getCityid() == search.getCityid1()){
                    n1 = true;
                    m1 = tmp.get(j).getNumber();
                }else if(tmp.get(j).getCityid() == search.getCityid2()){
                    n2 = true;
                    m2 = tmp.get(j).getNumber();
                }
            }
            if(((n1 == true) && (n2 == true)) && (m1 < m2)){
            }else{
                temp.remove(i);
                i--;
            }
        }
        System.out.println("查询完成！结果如下：");
        System.out.println(temp);
        //开始生成回传的数据
        List<UnsoldTicket> tickets = new ArrayList<UnsoldTicket>(temp.size());
        for(int i = 0; i < temp.size();i++){
            UnsoldTicket ticket = new UnsoldTicket();
            List<StopInfo> tmp = stopInfoMapper.getStopByTrainid(temp.get(i).getId());
            int[] path = new int[tmp.size()];
            int m = 0,n = 0;
            for(int j = 0; j<tmp.size(); j++){
                path[j] = tmp.get(j).getCityid();
                if (tmp.get(j).getCityid() == search.getCityid1()){
                    m = j;
                }else if (tmp.get(j).getCityid() == search.getCityid2()){
                    n = j;
                }
            }
            System.out.println(m+" "+n);
            float price = CalculatePrice(path,m,n);
            ticket.setPrice(price);
            StopInfo a1 = new StopInfo();
            CityInfo c1 = new CityInfo();
            c1.setId(search.getCityid1());
            c1.setName(cityInfoMapper.getNameByCityid(search.getCityid1()));
            CityInfo c2 = new CityInfo();
            c2.setId(search.getCityid2());
            c2.setName(cityInfoMapper.getNameByCityid(search.getCityid2()));
            a1.setCityInfo(c1);
            a1.setLeave(tmp.get(m).getLeave());
            StopInfo a2 = new StopInfo();
            a2.setArrive(tmp.get(n).getArrive());
            a2.setCityInfo(c2);
            TrainInfo a3 = new TrainInfo();
            a3.setNumber(temp.get(i).getNumber());
            ticket.setFromstop(a1);
            ticket.setTostop(a2);
            ticket.setTrainInfo(a3);

            //计算历时
            String leave = tmp.get(m).getLeave();
            String arrive = tmp.get(n).getArrive();
            String time = Calculatetime(leave,arrive);
            System.out.println(time);
            ticket.setSeatnumber(time);

            System.out.println(ticket);
            tickets.add(ticket);
        }

        return tickets;
    }
}

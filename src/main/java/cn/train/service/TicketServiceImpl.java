package cn.train.service;

import cn.train.enity.*;
import cn.train.mapper.*;
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
    @Autowired
    UnsoldTicketMapper unsoldTicketMapper;

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
        List<TrainInfo> temp = trainInfoMapper.getTrainByDay(search.getDay1());
        System.out.println("开始筛选当日车次...");
        for(int i = 0; i < temp.size(); i++){
            //该列车经停站信息tmp
            List<StopInfo> tmp = stopInfoMapper.getStopByTrainid(temp.get(i).getId());
            int m1 = 0,m2 = 0;
            boolean n1 = false,n2 = false;
            //判断该列车是否经过两个城市，m、n表示列车的站数
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
        //上面得到的信息List temp是经过两个站的所有列车的信息
        System.out.println("查询完成！结果如下：");
        System.out.println(temp);
        //下面开始生成回传的数据
        List<UnsoldTicket> tickets = new ArrayList<UnsoldTicket>(temp.size());
        //对每趟列车都生成一个UnsoldTicket型数据
        for(int i = 0; i < temp.size();i++){
            UnsoldTicket ticket = new UnsoldTicket();
            //该列车的所有停站信息
            List<StopInfo> tmp = stopInfoMapper.getStopByTrainid(temp.get(i).getId());
            int[] path = new int[tmp.size()];
            int m = 0,n = 0;
            //将所有的经停站的cityid生成一个path数组
            for(int j = 0; j<tmp.size(); j++){
                //m、n表示要求的城市在数组的索引
                //m出发站的索引，n到达站的索引
                path[j] = tmp.get(j).getCityid();
                if (tmp.get(j).getCityid() == search.getCityid1()){
                    m = j;
                }else if (tmp.get(j).getCityid() == search.getCityid2()){
                    n = j;
                }
            }
            System.out.println(m+" "+n);
            //计算价格
            float price = CalculatePrice(path,m,n);
            ticket.setPrice(price);
            //填充两个停站信息
            StopInfo a1 = new StopInfo();
            StopInfo a2 = new StopInfo();
            for (int j = 0; j<tmp.size();j++){
                if(tmp.get(j).getCityid() == search.getCityid1()){
                    a1 = tmp.get(j);
                }else if (tmp.get(j).getCityid() == search.getCityid2()){
                    a2 = tmp.get(j);
                }
            }
            //填充经停站的城市信息
            CityInfo c1 = cityInfoMapper.selectByPrimaryKey(search.getCityid1());
            CityInfo c2 = cityInfoMapper.selectByPrimaryKey(search.getCityid2());
            a1.setCityInfo(c1);
            a2.setCityInfo(c2);
//            TrainInfo a3 = new TrainInfo();
//            a3.setNumber(temp.get(i).getNumber());
            ticket.setFromstop(a1);
            ticket.setTostop(a2);
            ticket.setTrainInfo(temp.get(i));

            //计算并填充历时
            String leave = tmp.get(m).getLeave();
            String arrive = tmp.get(n).getArrive();
            String time = Calculatetime(leave,arrive);
            System.out.println(time);
            ticket.setSeatnumber(time);

            //完成一趟列车数据的填充，添加到返回值的列表中
            System.out.println(ticket);
            tickets.add(ticket);
        }

        return tickets;
    }

    @Override
    public int[] getUnsoldTicketNum(Search search) {
        System.out.println("查询余票数" + search);
        //注意：cityid中存储stopid而不是cityid
        //获取改车次所有余票数据
        List<UnsoldTicket> tickets = unsoldTicketMapper.getUnsoldTicketByTrainid(search.getTrainid());
        //获取该车次的所有经停站
        List<StopInfo> stops = stopInfoMapper.getStopByTrainid(search.getTrainid());
        //生成路径
        int[] path = new int[stops.size()];
        int a,b = 0;
        boolean m = false;
        for (int i=0;i<stops.size();i++){
            path[i] = stops.get(i).getId();
            if(path[i] == search.getCityid1()){
                a = i;
            }else if(path[i] == search.getCityid2()){
                b = i;
            }
        }
        //筛选车票，剔除不符要求的余票
        for (int i=0;i<tickets.size();i++){
            if(!((tickets.get(i).getFromstopid()<=search.getCityid1()) && (tickets.get(i).getFromstopid()>=search.getCityid2()))){
                tickets.remove(i);
                i--;
            }
        }
        //计算各类票的数量
        int[] result = new int[3];
        result[0] = result[1] =result[2] = 0;
        for(int i=0;i<tickets.size();i++){
            if (tickets.get(i).getSeatlevel() == 1){
                result[0]++;
            }else if (tickets.get(i).getSeatlevel() == 2){
                result[1]++;
            }else if (tickets.get(i).getSeatlevel() == 3){
                result[2]++;
            }
        }

        return result;
    }


}

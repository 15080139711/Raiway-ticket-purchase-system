package cn.train.enity;

public class StopInfo {
    private Integer id;

    private Integer trainid;

    private Integer cityid;

    private CityInfo cityInfo;

    private String arrive;

    private Integer parktime;

    private String left;

    private Integer number;

    private String ticketgate;

    public CityInfo getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo) {
        this.cityInfo = cityInfo;
    }

    @Override
    public String toString() {
        return "StopInfo{" +
                "id=" + id +
                ", trainid=" + trainid +
                ", cityid=" + cityid +
                ", cityInfo=" + cityInfo +
                ", arrive='" + arrive + '\'' +
                ", parktime=" + parktime +
                ", left='" + left + '\'' +
                ", number=" + number +
                ", ticketgate='" + ticketgate + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrainid() {
        return trainid;
    }

    public void setTrainid(Integer trainid) {
        this.trainid = trainid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive == null ? null : arrive.trim();
    }

    public Integer getParktime() {
        return parktime;
    }

    public void setParktime(Integer parktime) {
        this.parktime = parktime;
    }

    public String getleft() {
        return left;
    }

    public void setleft(String left) {
        this.left = left == null ? null : left.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTicketgate() {
        return ticketgate;
    }

    public void setTicketgate(String ticketgate) {
        this.ticketgate = ticketgate == null ? null : ticketgate.trim();
    }
}
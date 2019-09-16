package cn.train.enity;

public class SoldTicket {
    private Integer id;

    private Integer trainid;
    private TrainInfo trainInfo;

    private Integer fromstopid;

    private StopInfo fromstop;

    private StopInfo tostop;

    private Integer tostopid;

    private Float price;

    private String seatnumber;

    private String rownumber;

    private String carnumber;

    private Integer seatlevel;

    private Integer contactid;

    private Integer orderid;

    private ContactInfo contactInfo;

    @Override
    public String toString() {
        return "SoldTicket{" +
                "id=" + id +
                ", trainid=" + trainid +
                ", fromstopid=" + fromstopid +
                ", fromstop=" + fromstop +
                ", tostop=" + tostop +
                ", tostopid=" + tostopid +
                ", price=" + price +
                ", seatnumber='" + seatnumber + '\'' +
                ", rownumber='" + rownumber + '\'' +
                ", carnumber='" + carnumber + '\'' +
                ", seatlevel=" + seatlevel +
                ", contactid=" + contactid +
                ", orderid=" + orderid +
                ", contactInfo=" + contactInfo +
                '}';
    }

    public TrainInfo getTrainInfo() {
        return trainInfo;
    }

    public void setTrainInfo(TrainInfo trainInfo) {
        this.trainInfo = trainInfo;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public StopInfo getFromstop() {
        return fromstop;
    }

    public void setFromstop(StopInfo fromstop) {
        this.fromstop = fromstop;
    }

    public StopInfo getTostop() {
        return tostop;
    }

    public void setTostop(StopInfo tostop) {
        this.tostop = tostop;
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

    public Integer getFromstopid() {
        return fromstopid;
    }

    public void setFromstopid(Integer fromstopid) {
        this.fromstopid = fromstopid;
    }

    public Integer getTostopid() {
        return tostopid;
    }

    public void setTostopid(Integer tostopid) {
        this.tostopid = tostopid;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(String seatnumber) {
        this.seatnumber = seatnumber == null ? null : seatnumber.trim();
    }

    public String getRownumber() {
        return rownumber;
    }

    public void setRownumber(String rownumber) {
        this.rownumber = rownumber == null ? null : rownumber.trim();
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber == null ? null : carnumber.trim();
    }

    public Integer getSeatlevel() {
        return seatlevel;
    }

    public void setSeatlevel(Integer seatlevel) {
        this.seatlevel = seatlevel;
    }

    public Integer getContactid() {
        return contactid;
    }

    public void setContactid(Integer contactid) {
        this.contactid = contactid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }
}
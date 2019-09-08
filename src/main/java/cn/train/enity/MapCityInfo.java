package cn.train.enity;

public class MapCityInfo {
    private Integer id;

    private Integer cityid1;

    private Integer cityid2;

    private Integer distance;

    private Float price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCityid1() {
        return cityid1;
    }

    public void setCityid1(Integer cityid1) {
        this.cityid1 = cityid1;
    }

    public Integer getCityid2() {
        return cityid2;
    }

    public void setCityid2(Integer cityid2) {
        this.cityid2 = cityid2;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
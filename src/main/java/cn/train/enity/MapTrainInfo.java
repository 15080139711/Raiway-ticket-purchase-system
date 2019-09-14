package cn.train.enity;

public class MapTrainInfo {
    private Integer id;

    private String number;

    private Integer modelid;

    private Integer firststation;

    private Integer laststation;

    private Integer stopnumber;

    public Integer getModelid() {
        return modelid;
    }

    public void setModelid(Integer modelid) {
        this.modelid = modelid;
    }

    public Integer getFirststation() {
        return firststation;
    }

    public void setFirststation(Integer firststation) {
        this.firststation = firststation;
    }

    public Integer getLaststation() {
        return laststation;
    }

    public void setLaststation(Integer laststation) {
        this.laststation = laststation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Integer getStopnumber() {
        return stopnumber;
    }

    public void setStopnumber(Integer stopnumber) {
        this.stopnumber = stopnumber;
    }
}
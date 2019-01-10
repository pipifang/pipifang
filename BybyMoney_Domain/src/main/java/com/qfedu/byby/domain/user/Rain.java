package com.qfedu.byby.domain.user;

import java.util.Date;

public class Rain {
    private Integer id;

    private String region;

    private Date createtime;

    private Integer rainfull;

    private String point;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getRainfull() {
        return rainfull;
    }

    public void setRainfull(Integer rainfull) {
        this.rainfull = rainfull;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point == null ? null : point.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}
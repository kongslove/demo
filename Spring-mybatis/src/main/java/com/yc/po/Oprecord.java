package com.yc.po;

import java.util.Date;

public class Oprecord {
    private Integer id;

    private Integer accountid;

    private Double opmoney;

    private Date optime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public Double getOpmoney() {
        return opmoney;
    }

    public void setOpmoney(Double opmoney) {
        this.opmoney = opmoney;
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }
}
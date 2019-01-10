package com.qfedu.byby.common.vo;

import java.io.Serializable;
import java.util.List;

public class PageBean implements Serializable {
    private int code;
    private String msg;
    private int totalcount;
    private int totalpage;
    private int count;
    private int currpage;
    private int limit;
    private List<Object> data;

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurrpage() {
        return currpage;
    }

    public void setCurrpage(int currpage) {
        this.currpage = currpage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", totalcount=" + totalcount +
                ", totalpage=" + totalpage +
                ", count=" + count +
                ", currpage=" + currpage +
                ", limit=" + limit +
                ", data=" + data +
                '}';
    }
}

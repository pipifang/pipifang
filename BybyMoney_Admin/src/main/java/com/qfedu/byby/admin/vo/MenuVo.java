package com.qfedu.byby.admin.vo;

import com.qfedu.byby.admin.domain.Permission;

import java.util.List;

public class MenuVo {
    private Permission parent;
    private List<Permission> childrens;
    public Permission getParent() {
        return parent;
    }

    public void setParent(Permission parent) {
        this.parent = parent;
    }

    public List<Permission> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Permission> childrens) {
        this.childrens = childrens;
    }
}

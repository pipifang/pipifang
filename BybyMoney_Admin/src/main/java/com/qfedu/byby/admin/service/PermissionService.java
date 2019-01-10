package com.qfedu.byby.admin.service;

import com.qfedu.byby.admin.domain.Permission;
import com.qfedu.byby.admin.vo.PageVo;
import com.qfedu.byby.admin.vo.R;

import java.util.List;

public interface PermissionService {
    //新增权限
    R save(Permission permission);
    //查询用户的权限
    List<String> queryByAid(int aid);
    //分页
    PageVo<Permission> queryByPage(int page, int limit);
    //查询一级菜单
    List<Permission> queryFirstMenu();
}

package com.qfedu.byby.admin.service;

import com.qfedu.byby.admin.domain.Admin;
import com.qfedu.byby.admin.vo.MenuVo;
import com.qfedu.byby.admin.vo.PageVo;
import com.qfedu.byby.admin.vo.R;

import java.util.List;

public interface AdminService {

    //新增
    R save(Admin admin);
    //校验是否存在
    R checkName(String name);
    //登录---账号是否存在临时无效
    Admin login(String name,String password);
    //更新角色
    R updateRole(int[] rids,int uid);
    //查询用户的菜单
    List<MenuVo> queryMenu(int uid);
    PageVo<Admin> queryByPage(int page, int limit);
}

package com.qfedu.byby.admin.service;

import com.qfedu.byby.admin.domain.Role;
import com.qfedu.byby.admin.vo.PageVo;
import com.qfedu.byby.admin.vo.R;

import java.util.List;

public interface RoleService {
    //新增角色
    R save(Role role);
    //更新角色权限
    R updatePermission(int[] pids, int rid);
    //分页查询
    PageVo<Role> queryByPage(int page, int limit);
    //所有角色
    List<Role> queryAll();
    //获取某个用户的所有角色
    List<Integer> selectByAid(int aid);
}

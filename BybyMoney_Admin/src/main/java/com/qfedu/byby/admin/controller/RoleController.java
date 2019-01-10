package com.qfedu.byby.admin.controller;

import com.qfedu.byby.admin.domain.Role;
import com.qfedu.byby.admin.service.RoleService;
import com.qfedu.byby.admin.vo.PageVo;
import com.qfedu.byby.admin.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    //新增
    @PostMapping("/rolesave.do")
    public R save(Role role){
        return roleService.save(role);
    }
    //查询分页
    @GetMapping("/rolepage.do")
    public PageVo<Role> page(int page, int limit){
        return roleService.queryByPage(page,limit);
    }
    //获取所有角色
    @GetMapping("/roleall.do")
    public List<Role> all(){
        return roleService.queryAll();
    }
    @GetMapping("/roleaid.do")
    public List<Integer> queryByAid(int aid){
        return roleService.selectByAid(aid);
    }
}

package com.qfedu.byby.admin.controller;

import com.qfedu.byby.admin.domain.Permission;
import com.qfedu.byby.admin.service.PermissionService;
import com.qfedu.byby.admin.vo.PageVo;
import com.qfedu.byby.admin.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    //新增
    @PostMapping("/permissionsave.do")
    public R save(Permission permission){
        return permissionService.save(permission);
    }
    //查询
    @GetMapping("/permissionpage.do")
    public PageVo<Permission> page(int page, int limit){
        return permissionService.queryByPage(page,limit);
    }
    //查询一级菜单
    @RequestMapping("/permissionmenu.do")
    public List<Permission> rootmenu(){
        return permissionService.queryFirstMenu();
    }

}

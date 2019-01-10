package com.qfedu.byby.admin.serviceimpl;

import com.qfedu.byby.admin.common.RUtil;
import com.qfedu.byby.admin.domain.Permission;
import com.qfedu.byby.admin.mapper.PermissionMapper;
import com.qfedu.byby.admin.service.PermissionService;
import com.qfedu.byby.admin.vo.PageVo;
import com.qfedu.byby.admin.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public R save(Permission permission) {
        return RUtil.setRes(permissionMapper.insert(permission));
    }
    @Override
    public List<String> queryByAid(int aid) {
        return permissionMapper.selectByAid(aid);
    }
    @Override
    public PageVo<Permission> queryByPage(int page, int count) {
        int index=0;
        if(page>0){
            index=(page-1)*count;
        }
        return PageVo.createPage(permissionMapper.selectByPage(index,count),permissionMapper.selectCount());
    }

    @Override
    public List<Permission> queryFirstMenu() {
        return permissionMapper.selectByPid();
    }
}

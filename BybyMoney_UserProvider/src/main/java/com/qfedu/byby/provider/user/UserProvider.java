package com.qfedu.byby.provider.user;


import com.qfedu.byby.common.constant.SystemCon;
import com.qfedu.byby.common.util.ResultUtil;
import com.qfedu.byby.common.vo.ResultBean;
import com.qfedu.byby.domain.user.User;
import com.qfedu.byby.domain.user.UserLog;
import com.qfedu.byby.mapper.user.UserLogMapper;

import com.qfedu.byby.mapper.user.UserMapper;
import com.qfedu.byby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userprovider")
public class UserProvider implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserLogMapper userLogMapper;
   @Override
    public ResultBean save(User user, String ip)
    {
        ResultBean rb= ResultUtil.execOp(userMapper.insert(user),"用户注册");
        System.out.println("新增用户："+user.getId());
        userLogMapper.insert(new UserLog(user.getId(),"完成注册:"+user.getNickname(),ip));
        return rb;
    }

    @Override
    public ResultBean updatePass(int uid, String password, String ip) {
        userLogMapper.insert(new UserLog(uid,"重置密码：uid="+uid,ip));
        return ResultUtil.execOp(userMapper.updatePassword(uid,password),"重置密码");
    }


    @Override
    public ResultBean checkRepeat(String name) {
        User user=userMapper.selectByName(name);
        if(user==null){
            return ResultUtil.setOK("OK",null);
        }else {
            return ResultUtil.setError(SystemCon.RERROR1,"已经存在",null);
        }
    }
}

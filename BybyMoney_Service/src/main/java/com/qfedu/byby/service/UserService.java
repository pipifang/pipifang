package com.qfedu.byby.service;

import com.qfedu.byby.common.vo.ResultBean;
import com.qfedu.byby.domain.user.User;

public interface UserService {
    ResultBean save(User user, String ip);
    //修改密码
    ResultBean updatePass(int uid,String password,String ip);
    //校验昵称或手机号是否重复
    ResultBean checkRepeat(String name);
}

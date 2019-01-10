package com.qfedu.byby.provider.sso;

import com.alibaba.fastjson.JSON;
import com.qfedu.byby.common.constant.SystemCon;
import com.qfedu.byby.common.redis.JedisUtil;
import com.qfedu.byby.common.token.TokenUtil;
import com.qfedu.byby.common.util.ResultUtil;
import com.qfedu.byby.common.util.StringUtil;
import com.qfedu.byby.common.vo.ResultBean;
import com.qfedu.byby.domain.user.User;
import com.qfedu.byby.domain.user.UserLog;
import com.qfedu.byby.mapper.user.UserLogMapper;
import com.qfedu.byby.mapper.user.UserMapper;
import com.qfedu.byby.service.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service("ssoprovider")
public class SSOProvider implements SSOService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserLogMapper userLogMapper;
    @Autowired
    private JedisUtil jedisUtil;
    @Override
    public ResultBean login(String name, String password,String ip) {
        //获取登录的用户对象
        User user=userMapper.selectByName(name);
        //校验用户名是否存在
        if(user!=null){
            if(Objects.equals(user.getPassword(),password)){
                //登录成功
                //生成令牌
                String token=TokenUtil.createToken(JSON.toJSONString(user),user.getId());
                //存储令牌到Redis
                //采用Hash类型 存储的键为固定字符串+Token 存储的值是对应用户信息的json字符串
                jedisUtil.addHash(SystemCon.TOKENHASH,"token:"+token,JSON.toJSONString(user));
                //日志记录
                userLogMapper.insert(new UserLog(user.getId(),"登录成功：令牌："+token,ip));
                //返回值需要携带生成Token和对应的登录信息
                return ResultUtil.setOK(token,user);
            }
        }
        return ResultUtil.setError(SystemCon.RERROR1,"登录失败",null);
    }

    @Override
    public ResultBean checkLogin(String token) {
        String value=jedisUtil.getHash(SystemCon.TOKENHASH,"token:"+token);
        if(StringUtil.checkNoEmpty(value)){
            User user=JSON.parseObject(value,User.class);
            return ResultUtil.setOK("登录有效",user);
        }else{
            return ResultUtil.setError(SystemCon.RERROR1,"登录失效，请重新登录",null);
        }
    }

    @Override
    public ResultBean loginout(String token) {
        jedisUtil.delHash(SystemCon.TOKENHASH,"token:"+token);
        return ResultUtil.setOK("注销成功",null);
    }
}

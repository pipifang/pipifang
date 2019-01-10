package com.qfedu.byby.common.token;

import com.alibaba.fastjson.JSON;
import com.qfedu.byby.common.constant.SystemCon;
import com.qfedu.byby.common.util.EncrypUtil;

import java.util.Random;

public class TokenUtil {

    //创建用户令牌
    public static String createToken(String content,int id){
        Token token=new Token(content,System.currentTimeMillis(),id,new Random().nextLong());
        String json= JSON.toJSONString(token);
        return EncrypUtil.encAesStr(SystemCon.TOKENKEY,json);
    }
    //解析令牌
    public static Token parseToken(String token){
        String json=EncrypUtil.decAesStr(SystemCon.TOKENKEY,token);
        return JSON.parseObject(json,Token.class);
    }
    //更新令牌
    public static String updateToken(Token token){
        token.setTime(System.currentTimeMillis());
        return EncrypUtil.encAesStr(SystemCon.TOKENKEY,JSON.toJSONString(token));
    }

}

package com.qfedu.byby.common.test;


import com.qfedu.byby.common.constant.SystemCon;
import com.qfedu.byby.common.util.EncrypUtil;

public class PasswordTest {
    public static void main(String[] args) {
        String key= EncrypUtil.createAesKey();
        System.out.println(key);
        String res="HelloWord";
        //加密
        String es=EncrypUtil.encAesStr(SystemCon.TOKENKEY,res);
        System.out.println("1加密："+es);
        //解密
        System.out.println("1解密："+EncrypUtil.decAesStr(SystemCon.TOKENKEY,es));
        //加密
        String es2=EncrypUtil.encAesStr(SystemCon.PASSKEY,res);
        System.out.println("2加密："+es2);
        //解密
        System.out.println("2解密："+EncrypUtil.decAesStr(SystemCon.PASSKEY,es2));
    }
}

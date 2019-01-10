package com.qfedu.byby.test;

import com.qfedu.byby.common.util.EncrypUtil;

/**
 *@Author feri
 *@Date Created in 2018/11/30 14:36
 */
public class Pass_Test {
    public static void main(String[] args) {
        System.out.println("qfjava:"+ EncrypUtil.md5Pass("qfjava"));
    }
}

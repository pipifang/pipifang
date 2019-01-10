package com.qfedu.byby.common.test;


import com.qfedu.byby.common.constant.SystemCon;
import com.qfedu.byby.common.util.HttpUtils;

public class HttpTest {
    public static void main(String[] args) {
//        System.out.println(HttpUtils.getString(SystemCon.GET,
//                "http://t.weather.sojson.com/api/weather/city/101180101",null));
        System.out.println(HttpUtils.getString(SystemCon.GET,
                "http://www.baidu.com",null));
    }
}

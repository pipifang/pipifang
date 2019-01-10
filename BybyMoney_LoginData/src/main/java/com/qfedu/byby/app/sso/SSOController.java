package com.qfedu.byby.app.sso;


import com.qfedu.byby.common.constant.SystemCon;
import com.qfedu.byby.common.util.CookieUtil;
import com.qfedu.byby.common.vo.ResultBean;
import com.qfedu.byby.service.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class SSOController {
    @Autowired
    private SSOService ssoService;

    //登录
    public ResultBean login(String name, String password, HttpServletRequest request, HttpServletResponse response){
        if(CookieUtil.getCk(request,"usertoken")==null){
            ResultBean rb=ssoService.login(name,password,request.getRemoteAddr());
            if(rb.getCode()== SystemCon.ROK){
                //存储令牌到Cookie
               CookieUtil.setCK(response,"usertoken",rb.getMsg());
               rb.setMsg("登录成功");
               return rb;
            }else {
                return rb;
            }
        }else{
            //存在Token
            //校验Token
            return null;
        }
    }
}

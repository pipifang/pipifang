package com.qfedu.byby.app;

import com.qfedu.byby.qrcode.QrcodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class QrCodeController {

    //生成二维码
    @GetMapping("/qrcodecreate.do")
    public void create(String msg, HttpServletResponse response) throws IOException {
        QrcodeUtil.createCode(msg,response.getOutputStream());
    }
}

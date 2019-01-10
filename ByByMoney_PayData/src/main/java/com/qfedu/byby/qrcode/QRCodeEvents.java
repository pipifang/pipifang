package com.qfedu.byby.qrcode;

import java.util.Scanner;

import static com.qfedu.byby.qrcode.QrcodeUtil.generateQRCode;
import static com.qfedu.byby.qrcode.QrcodeUtil.parseQRCode;

/**
 * @Author : zcg
 * @Data ：Create in 14:492019/1/10
 */
public class QRCodeEvents {
    public static void main(String[] args) {

        //String text = generateNumCode(12);  //随机生成的12位验证码
        System.out.println("请输入：");
        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        System.out.println("需要生成二维码的内容是： " + text);
        int width = 200;    //二维码图片的宽
        int height = 200;   //二维码图片的高
        String format = "png";  //二维码图片的格式

        try {
            //生成二维码图片，并返回图片路径
            String pathName = generateQRCode(text, width, height, format);
            System.out.println("生成二维码的图片路径： " + pathName);

            String content = parseQRCode(pathName);
            System.out.println("解析出二维码的图片的内容为： " + content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

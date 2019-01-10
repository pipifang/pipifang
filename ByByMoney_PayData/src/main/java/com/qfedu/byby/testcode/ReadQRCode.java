package com.qfedu.byby.testcode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ReadQRCode {
    public static void main(String[] args) throws IOException, NotFoundException {
        MultiFormatReader formatReader = new MultiFormatReader();

        //二维码地址
        File file = new File("D:/a/code.png");
        BufferedImage image;

        image = ImageIO.read(file);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));

        HashMap hints = new HashMap();
        //指定字符编码为utf-8
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");

        //优化精度
        hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        //复杂模式，开启PURE_BARCODE模式
        hints.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);

        Result result = formatReader.decode(binaryBitmap,hints);

//        System.out.println("解析结果为："+result.toString());

//        System.out.println("二维码格式为："+result.getBarcodeFormat());

        System.out.println("二维码内容："+result.getText());
    }
}

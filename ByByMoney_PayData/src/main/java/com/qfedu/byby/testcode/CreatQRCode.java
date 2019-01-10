package com.qfedu.byby.testcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

public class CreatQRCode {

    public static void main(String[] args) throws WriterException, IOException {
        //图片的宽度
        int width=300;
        //图片的高度
        int height=300;
        //图片的格式
        String format="png";
        //内容
        String content="有趣";

        /**

         * 定义二维码的参数

         */

        HashMap hints=new HashMap();

        //指定字符编为“utf-8”
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");

        //指定二维码的纠错等级为中级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);

        //设置图片的边距

        hints.put(EncodeHintType.MARGIN, 2);

        /**

         * 生成二维码

         */

        BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
        //二维码生成地址
        Path file=new File("D:/a/code.png").toPath();

        MatrixToImageWriter.writeToPath(bitMatrix, format, file);

    }


}


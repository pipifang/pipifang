package com.qfedu.byby.qrcode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class QrcodeUtil {
    public static void main(String[] args) throws Exception {
        //createCode("Java1805美女帅哥比较多");
         //createQrCode("醒醒",FileUtils.readFileToByteArray(new File("favicon.ico")),new File("1805.png"));
        createQrCode("醒醒", new File("log.png"), new File("1805.png"));
    }

    public static final String IMAGESUF = "png";
    //生成二维码 普通  存储到本地文件中

    public static void createCode(String msg) {

        try {
            Map param = new HashMap();
            param.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            param.put(EncodeHintType.MARGIN, 5);
            param.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
            //生成二维码
            BitMatrix bitMatrix = new MultiFormatWriter().encode(msg, BarcodeFormat.QR_CODE, 200, 200,param);

            //基于NIO创建路径对象
            File file = new File("mt.png");
            Path path = file.toPath();
            //保存到指定路径
            MatrixToImageWriter.writeToPath(bitMatrix, IMAGESUF, path);
            System.out.println(file.getAbsolutePath());
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //生成二维码 普通  存储到本地文件中
    public static void createCode(String msg, File desfile) {
        try {
            Map param = new HashMap();
            param.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            param.put(EncodeHintType.MARGIN, 5);
            param.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
            //生成二维码
            BitMatrix bitMatrix = new MultiFormatWriter().encode(msg, BarcodeFormat.QR_CODE, 200, 200, param);
            //基于NIO创建路径对象
            Path path = desfile.toPath();
            //保存到指定路径
            MatrixToImageWriter.writeToPath(bitMatrix, IMAGESUF, path);
            System.out.println(desfile.getAbsolutePath());
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //生成二维码 普通  存储到本地文件中
    public static void createCode(String msg, OutputStream os) {
        try {
            Map param = new HashMap();
            param.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            param.put(EncodeHintType.MARGIN, 5);
            param.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
            //生成二维码
            BitMatrix bitMatrix = new MultiFormatWriter().encode(msg, BarcodeFormat.QR_CODE, 200, 200, param);

            //保存到指定输出流
            MatrixToImageWriter.writeToStream(bitMatrix, IMAGESUF, os);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建二维码，带图片的
    public static void createQrCode(String msg, File images, File defFile) throws Exception {
        //1、二维码参数设置
        Map param = new HashMap();
        param.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        param.put(EncodeHintType.MARGIN, 1);
        param.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        //2、生成二维码
        BitMatrix bitMatrix = new MultiFormatWriter().encode(msg, BarcodeFormat.QR_CODE, 300, 300, param);
        int cw = bitMatrix.getWidth();
        int ch = bitMatrix.getHeight();
        //3、创建要生成图片

        BufferedImage image = new BufferedImage(bitMatrix.getWidth(), bitMatrix.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        //4、复制内容
        for (int x = 0; x < cw; x++) {
            for (int y = 0; y < ch; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        //4、压缩处理传入的图片
        //原来的
        Image viewImage = ImageIO.read(images);
        //获取原来大小
        int w = viewImage.getWidth(null);
        int h = viewImage.getHeight(null);
        if (w > cw / 2) {
            w = cw / 2;
        }
        if (h > ch / 2) {
            h = ch / 2;
        }
        //获取裁剪后的图片
        Image src = viewImage.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        BufferedImage desImg = new BufferedImage(w, h, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics graphics = desImg.getGraphics();
        graphics.drawImage(src, 0, 0, null);
        graphics.dispose();

        //5、合成图片
        Graphics2D graphics2D = image.createGraphics();
        int x = (cw - w) / 2;
        int y = (ch - h) / 2;
        graphics2D.drawImage(viewImage, x, y, w, h, null);
        Shape shape = new RoundRectangle2D.Float(x, y, w, h, 6, 6);
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.draw(shape);
        graphics2D.dispose();
        ImageIO.write(image, IMAGESUF, defFile);
    }

    /**
     * 根据内容，生成指定宽高、指定格式的二维码图片
     *
     * @param text   内容
     * @param width  宽
     * @param height 高
     * @param format 图片格式
     * @return 生成的二维码图片路径
     * @throws Exception
     */
    public static String generateQRCode(String text, int width, int height, String format) throws Exception {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
        String pathName = "D:/a/new.png";
        File outputFile = new File(pathName);
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
        return pathName;
    }


    /**
     * 随机生成指定长度的验证码
     *
     * @param length 验证码长度
     * @return 生成的验证码
     */
    public static String generateNumCode(int length) {
        String val = "";
        String charStr = "char";
        String numStr = "num";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? charStr : numStr;
            //输出字母还是数字
            if (charStr.equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if (numStr.equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 解析指定路径下的二维码图片
     *
     * @param filePath 二维码图片路径
     * @return
     */
    public static String parseQRCode(String filePath) {
        String content = "";
        try {
            File file = new File(filePath);
            BufferedImage image = ImageIO.read(file);
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            MultiFormatReader formatReader = new MultiFormatReader();
            Result result = formatReader.decode(binaryBitmap, hints);

            System.out.println("result 为：" + result.toString());
            System.out.println("resultFormat 为：" + result.getBarcodeFormat());
            System.out.println("resultText 为：" + result.getText());
            //设置返回值
            content = result.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
}

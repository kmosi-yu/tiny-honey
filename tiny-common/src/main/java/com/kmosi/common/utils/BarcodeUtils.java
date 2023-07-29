package com.kmosi.common.utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.kmosi.common.domain.meta.ImageMeta;
import lombok.SneakyThrows;
import org.bouncycastle.util.encoders.Base64;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-03-14 09:53
 * @description 二维码生成及解析
 */
public class BarcodeUtils {

    /**
     * 创建二维码
     *
     * @param meta 元数据
     * @return InputStream
     */
    @SneakyThrows
    public static InputStream generateInputStream(ImageMeta meta) {
        return new ByteArrayInputStream(generateByte(meta));
    }

    /**
     * 创建二维码
     *
     * @param meta 元数据
     * @return byte[]
     */
    @SneakyThrows
    public static byte[] generateByte(ImageMeta meta) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        var image = buildQRCode(meta);
        ImageIO.write(image, "PNG", bytes);
        return bytes.toByteArray();
    }

    /**
     * 创建二维码
     *
     * @param meta 元数据
     * @return OutputStream
     */
    @SneakyThrows
    public static OutputStream generateOutputStream(ImageMeta meta, String path) {
        OutputStream stream = new FileOutputStream(path);
        var image = buildQRCode(meta);
        ImageIO.write(image, "PNG", stream);
        return stream;
    }


    /**
     * 创建二维码
     *
     * @param meta 元数据
     * @return boolean
     */
    @SneakyThrows
    public static boolean generateFile(ImageMeta meta, String path) {
        OutputStream stream = new FileOutputStream(path);
        var image = buildQRCode(meta);
        return ImageIO.write(image, "PNG", stream);
    }

    /**
     * 创建二维码
     *
     * @param meta 元数据
     * @return string：Base64
     */
    @SneakyThrows
    public static String generateBase64(ImageMeta meta) {
        BufferedImage image = buildQRCode(meta);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(image, "PNG", stream);
        return "data:image/jpeg;base64," + new String(Base64.encode(stream.toByteArray()));
    }

    /**
     * 创建二维码
     *
     * @param meta 元数据
     * @return BufferedImage
     */
    @SneakyThrows
    private static BufferedImage buildQRCode(ImageMeta meta) {
        var bitMatrix = buildMatrix(meta.getContent(), meta.getWidth(), meta.getHeight());
        var image = buildImage(bitMatrix, meta.getSColor(), meta.getEColor(), meta.getBgColor());
        return buildLogo(image, meta.getLogo());
    }

    /**
     * 设置颜色的方法
     *
     * @param bitMatrix  位图
     * @param startColor 开始颜色
     * @param endColor   结束颜色
     * @return image
     */
    private static BufferedImage buildImage(BitMatrix bitMatrix, Color startColor, Color endColor, Color bgColor) {
        BufferedImage image = new BufferedImage(bitMatrix.getWidth(), bitMatrix.getHeight(), BufferedImage.TYPE_INT_RGB);
        int sR = startColor.getRed(), sG = startColor.getGreen(), sB = startColor.getBlue(),
                eR = endColor.getRed(), eG = endColor.getGreen(), eB = endColor.getBlue();
        // 计算公式为：A + (B-A) / Step * N
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                if (bitMatrix.get(x, y)) {
                    int red = sR + ((eR - sR) * y / image.getWidth());
                    int green = sG + ((eG - sG) * y / image.getWidth());
                    int blue = sB + ((eB - sB) * y / image.getWidth());
                    image.setRGB(x, y, new Color(red, green, blue).getRGB());
                } else {
                    image.setRGB(x, y, bgColor.getRGB());
                }
            }
        }
        return image;
    }

    /**
     * @param content 内容
     * @param width   宽
     * @param height  高
     * @return BitMatrix
     */
    @SneakyThrows
    private static BitMatrix buildMatrix(String content, int width, int height) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        //定义Map集合封装二维码配置信息
        Map<EncodeHintType, Object> hints = new HashMap<>(16);
        // 设置二维码图片的内容编码
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 设置二维码图片的上、下、左、右间隙
        hints.put(EncodeHintType.MARGIN, 1);
        // 设置二维码的纠错级别  L<M<Q<H
        hints.put(EncodeHintType.ERROR_CORRECTION,
                ErrorCorrectionLevel.H);
        // 图像数据转换，使用了矩阵转换
        return qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
    }

    /**
     * 创建LOGO
     *
     * @param image 二维码
     * @param logo  logo
     * @return 图像
     */
    @SneakyThrows
    private static BufferedImage buildLogo(BufferedImage image, BufferedImage logo) {
        if (logo != null) {
            // 创建Graphics2D-->graphics
            Graphics2D graphics = image.createGraphics();
            int height = image.getHeight();
            int width = image.getWidth();
            // 进行Logo的缩放，减少失真
            Image newLogo = logo.getScaledInstance(width / 5, height / 5, Image.SCALE_SMOOTH);
            graphics.drawImage(newLogo, width / 5 * 2, height / 5 * 2, null);
            //创建 画笔
            BasicStroke stroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            //给graphics关联画笔
            graphics.setStroke(stroke);
            //创建一个正方形
            RoundRectangle2D.Float round = new RoundRectangle2D.Float(width * 2F / 5F, height * 2F / 5F, width / 5F, height / 5F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            graphics.setColor(Color.WHITE);
            graphics.draw(round);
            // 关掉graphics
            graphics.dispose();
        }
        return image;
    }

    /**
     * 内容解析
     *
     * @param file 文件
     * @return 字符串
     */
    @SneakyThrows
    public static String readContent(File file) {
        BufferedImage image = ImageIO.read(file);
        return decode(image);
    }

    /**
     * 内容解析
     *
     * @param inputStream 文件
     * @return 字符串
     */
    @SneakyThrows
    public static String readContent(InputStream inputStream) {
        BufferedImage image = ImageIO.read(inputStream);
        return decode(image);
    }

    /**
     * 内容解析
     *
     * @param image 文件
     * @return 字符串
     */
    @SneakyThrows
    private static String decode(BufferedImage image) {
        if (image == null) {
            return "";
        }
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Map<DecodeHintType, Object> hints = new HashMap<>(16);
        hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
        Result result = new MultiFormatReader().decode(bitmap, hints);
        return result.getText();
    }
}

package com.kmosi.common.utils;

import com.kmosi.common.domain.meta.ImageMeta;
import lombok.SneakyThrows;
import org.bouncycastle.util.encoders.Base64;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2024-01-15 11:01
 * @description
 */
public class CharToImageUtils {

    /**
     * 生成图片
     *
     * @param imageMeta 元数据
     * @return 图片
     */
    public static BufferedImage buildImage(ImageMeta imageMeta) {
        // 获取必要的数据
        int width = imageMeta.getWidth();
        int height = imageMeta.getHeight();
        Font font = imageMeta.getFont();
        // 1.创建空白图片
        BufferedImage image = new BufferedImage(
                width, height, BufferedImage.TYPE_INT_ARGB);
        // 2.获取图片画笔
        Graphics2D graphic = image.createGraphics();
        // 3.设置背景颜色为白色
        graphic.setColor(imageMeta.getBgColor());
        // 4.绘制背景填充
        graphic.fillRect(0, 0, width, height);
        // 6.设置字体和文字大小
        graphic.setFont(font);
        // 7.设置字体颜色
        graphic.setColor(imageMeta.getFontColor());
        // 8.获取字体的宽度和高度
        int textWidth = graphic.getFontMetrics().stringWidth(imageMeta.getContent());
        int textHeight = graphic.getFontMetrics().getHeight();
        // 8.1获取文本开始绘制的x点位
        int x = (width - textWidth) / 2;
        // 8.2获取文本开始绘制的y点位
        int y = ((height - font.getSize()) / 2) + (font.getSize() - ((textHeight - font.getSize()) / 2));
        // 9.绘制文字
        graphic.drawString(imageMeta.getContent(), x, y);
        // 9.1释放资源
        graphic.dispose();
        return image;
    }

    /**
     * 判断字符串是否为中文
     *
     * @param content 文本
     * @return true/false
     */
    public static boolean isChinese(String content) {
        String regExpress = "[\\u4e00-\\u9fa5]+";
        Pattern p = Pattern.compile(regExpress);
        Matcher m = p.matcher(content);
        return m.find();
    }

    /**
     * 生成图片
     *
     * @param imageMeta 元数据
     * @return 图片
     */
    @SneakyThrows
    public static String generateBase64(ImageMeta imageMeta) {
        BufferedImage image = buildImage(imageMeta);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(image, "PNG", stream);
        return "data:image/jpeg;base64," + new String(Base64.encode(stream.toByteArray()));
    }
}

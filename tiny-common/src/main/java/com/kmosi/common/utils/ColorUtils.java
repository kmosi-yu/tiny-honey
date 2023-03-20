package com.kmosi.common.utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-03-15 16:49
 * @description 渐变色
 */
public class ColorUtils {
    private static List<Integer> mergeColor(Color startColor, Color endColor, int step) {
        List<Integer> colors = new ArrayList<>();
        int sR = startColor.getRed(), sG = startColor.getGreen(), sB = startColor.getBlue(),
                eR = endColor.getRed(), eG = endColor.getGreen(), eB = endColor.getBlue();
        // 计算公式为：A + (B-A) / Step * N
        for (int i = 0; i < step; i++) {
            int red = sR + ((eR - sR) * i / step);
            int green = sG + ((eG - sG) * i / step);
            int blue = sB + ((eB - sB) * i / step);
            colors.add(new Color(red, green, blue).getRGB());
        }
        return colors;
    }
}

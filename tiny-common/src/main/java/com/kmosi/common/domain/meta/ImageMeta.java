package com.kmosi.common.domain.meta;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-03-14 15:20
 * @description
 */
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageMeta implements Serializable {
    @Serial
    private static final long serialVersionUID = 2659082648167329608L;
    /**
     * 内容
     */
    @Getter
    private String content;
    /**
     * 宽
     */
    @Getter
    private int width;
    /**
     * 高
     */
    @Getter
    private int height;
    /**
     * logo
     */
    private BufferedImage logo;
    /**
     * logo地址
     */
    @Getter
    private String logoPath;
    /**
     * 开始颜色
     */
    @Getter
    private Color sColor = new Color(0, 0, 0);
    /**
     * 结束颜色
     */
    @Getter
    private Color eColor = new Color(0, 0, 0);
    /**
     * 背景颜色
     */
    @Getter
    private Color bgColor = new Color(255, 255, 255);

    @SneakyThrows
    public BufferedImage getLogo() {
        if (logo == null && StringUtils.isNotBlank(logoPath)) {
            return ImageIO.read(new File(logoPath));
        } else {
            return logo;
        }
    }
}

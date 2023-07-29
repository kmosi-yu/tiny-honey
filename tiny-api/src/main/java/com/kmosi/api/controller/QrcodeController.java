package com.kmosi.api.controller;

import com.kmosi.common.domain.meta.ImageMeta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.IOException;

import static com.kmosi.common.utils.BarcodeUtils.generateByte;
import static com.kmosi.common.utils.BarcodeUtils.readContent;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-07-29 14:50
 * @description 二维码 QRCode API
 */
@RequestMapping("/utils/v1/qr")
@Tag(name = "二维码处理")
@RestController
@Validated
public class QrcodeController {
    /**
     * 生成二维码（含logo）
     *
     * @param content 内容
     * @param logo    Logo地址
     * @return base64
     */
    @PostMapping(value = "/image",
            produces = "application/octet-stream;charset=UTF-8")
    @Operation(summary = "生成二维码（含logo）")
    @Parameters(value = {
            @Parameter(name = "content", description = "内容"),
            @Parameter(name = "logo", description = "Logo地址")
    })
    public byte[] getImage(@NotNull(message = "内容不能为空") String content, MultipartFile logo) throws IOException {
        var imageMeta = ImageMeta.builder()
                .height(200)
                .width(200)
                .content(content)
                .logo(logo != null ? ImageIO.read(logo.getInputStream()) : null)
                .build();
        return generateByte(imageMeta);
    }

    /**
     * 生成二维码（不含logo）
     *
     * @param content 内容
     * @return base64
     */
    @GetMapping(value = "/image",
            produces = "application/octet-stream;charset=UTF-8")
    @Operation(summary = "生成二维码（不含logo）")
    @Parameters(value = {
            @Parameter(name = "content", description = "内容", in = ParameterIn.QUERY)
    })
    public byte[] getImage(@NotNull(message = "内容不能为空") String content) {
        var imageMeta = ImageMeta.builder()
                .height(200)
                .width(200)
                .content(content)
                .build();
        return generateByte(imageMeta);
    }

    /**
     * 解析二维码
     *
     * @param image 文件
     * @return base64
     */
    @PostMapping(value = "/content")
    @Operation(summary = "解析二维码")
    @Parameters(value = {
            @Parameter(name = "image", description = "文件")
    })
    public String getContent(MultipartFile image) throws IOException {
        return readContent(image.getInputStream());
    }
}

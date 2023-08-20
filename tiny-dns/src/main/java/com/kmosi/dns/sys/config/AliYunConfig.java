package com.kmosi.dns.sys.config;

import com.aliyun.alidns20150109.Client;
import com.aliyun.teaopenapi.models.Config;
import com.kmosi.dns.common.domain.meta.AliYunMeta;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-12 21:15
 * @description 阿里云客户端配置
 */
@Configuration
public class AliYunConfig {
    @Resource
    private AliYunMeta aliYunMeta;

    /**
     * 使用AK&SK初始化账号Client
     *
     * @return Client 客户端
     * @throws Exception 异常
     */
    @Bean
    public Client client() throws Exception {
        Config config = new Config()
                // 必填，您的 AccessKey ID
                .setAccessKeyId(aliYunMeta.getAccessKeyId())
                // 必填，您的 AccessKey Secret
                .setAccessKeySecret(aliYunMeta.getAccessKeySecret());
        // 获取接入点 请参考 https://api.aliyun.com/product/Alidns
        config.endpoint = aliYunMeta.getEndpoint();
        return new Client(config);
    }
}

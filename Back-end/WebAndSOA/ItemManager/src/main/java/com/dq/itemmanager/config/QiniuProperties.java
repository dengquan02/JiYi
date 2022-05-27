package com.dq.itemmanager.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: Gu HungJou
 * @date: 2022/5/15 16:25
 * Describe:
 */
@Data
@ConfigurationProperties(prefix = "qiniu")
public class QiniuProperties {

    private String accessKey;

    private String secretKey;

    private String bucket;

    private String prefix;
}

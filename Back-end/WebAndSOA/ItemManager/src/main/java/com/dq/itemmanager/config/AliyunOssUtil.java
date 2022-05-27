package com.dq.itemmanager.config;

/**
 * @author: Gu HungJou
 * @date: 2022/5/11 13:22
 * Describe:
 */
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.File;

public class AliyunOssUtil {

    public static final String endpoint = "oss-cn-shanghai.aliyuncs.com";
    public static final String accessKeyId = "LTAI5t9WQu7vNQFDQ6W7Xcu2";
    public static final String accessKeySecret = "KRg1GEEFpIGNPuBxzsKmEYn9HGt8WA";
    public static final String bucketName = "ghzoss";

    public static OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

    public static void main(String[] args) {
        ossClient.putObject(bucketName, "im1.jpg", new File("src/main/java/com/ghz/diagnosis/controller/im2.jpg"));
        ossClient.shutdown();
        System.out.println("上传图片完成！");
    }

}

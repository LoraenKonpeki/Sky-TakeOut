package com.sky.utils;

import io.minio.*;
import io.minio.errors.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Data
@AllArgsConstructor
@Slf4j
public class MinioOssUtil {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

    public String upload(byte[] bytes, String objectName) {
        MinioClient minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKeyId, accessKeySecret)
                .build();

        try {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .stream(new ByteArrayInputStream(bytes), bytes.length, -1)
                            .build()
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error Message:" + e.getMessage());
        } finally {
            if (minioClient != null) {
                try {
                    minioClient.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        String filePath = endpoint + "/" + bucketName + "/" + objectName;
        log.info("文件上传到：{}", filePath);
        return filePath;
    }
}

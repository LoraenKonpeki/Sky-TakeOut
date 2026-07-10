package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import com.sky.utils.MinioOssUtil;
import io.lettuce.core.pubsub.RedisPubSubListener;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * 通用接口
 */
@RestController
@RequestMapping("/admin/common")
@Slf4j
@Api(tags = "通用控制接口")
public class CommonController {

    @Autowired
    private MinioOssUtil minioOssUtil;

    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        log.info("文件上传：{}", fileName);
        try {
            String extension = null;
            if (fileName != null) {
                extension = fileName.substring(fileName.lastIndexOf("."));
            }
            String objectName = UUID.randomUUID().toString().replaceAll("-", "") + extension;
            String filePath = minioOssUtil.upload(file.getBytes(), objectName);
            return Result.success(filePath);
        } catch (IOException e) {
            log.error(e.getMessage());
//            throw new RuntimeException(e);
        }
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}

package com.sky.controller.user;

import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user/shop")
@RestController("userShopController")
@Slf4j
@Api(tags = "店铺相关接口")
public class ShopController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/status")
    @ApiOperation(value = "商店状态查询")
    public Result<Integer> getStatus() {
        Integer status = (Integer) redisTemplate.opsForValue().get("SHOP_STATUS");
        log.info("获取到店铺状态：{}", status.equals(StatusConstant.ENABLE)? MessageConstant.SHOP_OPEN : MessageConstant.SHOP_CLOSED);
        return Result.success(status);
    }
}

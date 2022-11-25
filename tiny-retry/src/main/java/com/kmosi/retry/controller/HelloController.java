package com.kmosi.retry.controller;

import com.kmosi.retry.domain.vo.ResponseResult;
import com.kmosi.retry.service.HelloService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2022-08-07 21:32
 * @description say hello or hi控制器
 */
@RestController
public class HelloController {
    @Resource
    private HelloService helloService;

    /**
     * say hello or hi
     *
     * @param name 名字
     * @return ResponseResult
     * @throws Exception 自定义异常
     */
    @GetMapping("say")
    public ResponseResult<Map<String, String>> say(String name) throws Exception {
        String helloStr = helloService.hello(name);
        String hiStr = helloService.hi(name);
        return ResponseResult.buildSuccess("接口请求成功！", Map.of("hello", helloStr, "hiStr", hiStr));
    }
}

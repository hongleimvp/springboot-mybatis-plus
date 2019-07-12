package com.hong.lei.controller;

import com.hong.lei.service.AppService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.iutil.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description:    App 测试示例
* @Author:         lei.hong
* @param
* @exception
* @CreateDate:     2019-07-06 23:53
* @UpdateUser:     lei.hong
* @UpdateDate:     2019-07-06 23:53
* @UpdateRemark:   修改内容
* @Version:        1.0
*/

@Slf4j
@RestController
@RequestMapping(value = "/app", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(tags = "App 测试示例")
public class AppController {

    @Autowired
    private AppService mpCityService;


    // 查询所有城市
    @GetMapping("/eduTest")
    public ApiResult eduTest() {
        return ApiResult.success("投教通...............");
    }


}

package com.hong.lei;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* @Description:    启动入口
* @Author:         lei.hong
* @param
* @exception
* @CreateDate:     2019-07-12 16:30
* @UpdateUser:     lei.hong
* @UpdateDate:     2019-07-12 16:30
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@EnableSwagger2
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.hong.lei.mapper")
public class Application {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

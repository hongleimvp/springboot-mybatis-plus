package com.hong.lei.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
* @Description:    java类作用描述
* @Author:         lei.hong
* @param
* @exception
* @CreateDate:     2019-07-06 23:53
* @UpdateUser:     lei.hong
* @UpdateDate:     2019-07-06 23:53
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@EnableSwagger2
@Configuration
public class SwaggerConfigure {

    @Bean
    public Docket createRestApi() {
        //可以添加多个header或参数
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder
                .parameterType("header") //参数类型支持header, cookie, body, query etc
                .name("Authorization") //参数名
                .defaultValue("") //默认值
                .description("header中测试token字段")
                .modelRef(new ModelRef("string"))//指定参数值的类型
                .required(false).build(); //非必需，这里是全局配置，然而在登陆的时候是不用验证的
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(parameterBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(
                        "com.hong.lei"
                ))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(parameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("hong.lei Rest API")
                .description("honglei Rest Rest API")
                .termsOfServiceUrl("/")
                .contact(new Contact("NothingNull", "http://www.hong.lei.com", "NothingNull@foxmail.com"))
                .version("1.0")
                .build();
    }

}

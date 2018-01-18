package com.liotw.springboot.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger是一款RESTful接口的文档在线自动生成+功能测试功能软件
 * @author jiangjialiang on 2017/12/20
 * @version 1.0.0
 */
@Configuration
@EnableSwagger2
public class Swagger {

    @Bean
    public Docket creatRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liotw.springboot.jpa.web"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 访问：/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("title")
                .description("description")
                .termsOfServiceUrl("http://IP:Port/swagger-ui.html")
                .contact("jiangjialiang")
                .version("3.0.0")
                .build();
    }
}

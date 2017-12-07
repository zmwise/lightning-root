package com.osc.app.config.swagger2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @description: Swagger2构建强大的RESTful API文档
 * 访问地址：http://localhost:8080/swagger-ui.html
 * @author: lizhiming
 * @since: 2017/11/14
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    private static Logger LOGGER = LoggerFactory.getLogger(Swagger2Config.class);

    @Bean
    public Docket createRestApi() {
        LOGGER.info("【Swagger2配置】初始化配置文件");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.osc.oscashapp.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .version("1.0")
                .build();
    }
}

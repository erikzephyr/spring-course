package com.pluralsight.springcourse.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api-1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pluralsight.springcourse.swagger.api"))
                .paths(PathSelectors.ant("/spring-course/swagger/v1/pcs/*"))
                .build()
                .apiInfo(getApiInfo("1.0.0"));
    }

    @Bean
    public Docket api2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api-2")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pluralsight.springcourse.swagger.api"))
                .paths(PathSelectors.ant("/spring-course/swagger/v2/pcs/*"))
                .build()
                .apiInfo(getApiInfo("2.0.0"));
    }

    private ApiInfo getApiInfo(String version) {
        return new ApiInfoBuilder()
                .title("Titulo Api")
                .version(version)
                .licenseUrl("url-licencia")
                .termsOfServiceUrl("términos del servicio")
                .description("Descripción")
                .contact(new Contact("Erik Zephyr", "", "contact@erikzephyr.com"))
                .license("Licencia")
                .build();
    }

}

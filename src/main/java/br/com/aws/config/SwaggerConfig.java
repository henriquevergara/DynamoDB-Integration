package br.com.aws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${config.swagger.basePackage}")
    private String basePackage;
    @Value("${config.swagger.title}")
    private String title;
    @Value("${config.swagger.description}")
    private String description;
    @Value("${config.swagger.version}")
    private String version;
    @Value("${config.swagger.termsOfServiceUrl}")
    private String termsOfServiceUrl;
    @Value("${config.swagger.contact.name}")
    private String name;
    @Value("${config.swagger.contact.url}")
    private String url;
    @Value("${config.swagger.contact.email}")
    private String email;
    @Value("${config.swagger.license}")
    private String license;
    @Value("${config.swagger.licenseUrl}")
    private String licenseUrl;

    @Bean
    public Docket serviceApi() {

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(basePackage)).paths(PathSelectors.any()).build()
                .apiInfo(termosEServicos());
    }

    private ApiInfo termosEServicos() {
        return new ApiInfo(title, description, version, termsOfServiceUrl,
                new Contact(name, url, email), license, licenseUrl,
                Collections.emptyList());
    }
}

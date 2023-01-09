package com.lonar.vendor.vendorportal.config;

/*import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwagerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact("Parag Thikekar", "", "");
    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Test Documentation", "Test Documentation", "1.0", "urn:tos",
              DEFAULT_CONTACT, "Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());

 

    @Bean 
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO) ;
    }
}*/


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 

import com.google.common.base.Predicate;

 

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import static com.google.common.base.Predicates.or;

 

@Configuration
@EnableSwagger2
public class SwagerConfig {

 

    /*@Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }*/

 

/*    private Predicate<String> postPaths() {
        return or(regex("/api/posts.*"), regex("/api/javainuse.*"));
    }
*/
 

  /*  private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("JavaInUse API")
                .description("JavaInUse API reference for developers")
                .termsOfServiceUrl("http://javainuse.com")
                .contact("javainuse@gmail.com").license("JavaInUse License")
                .licenseUrl("javainuse@gmail.com").version("1.0").build();
    
        
        }*/
	
    /*@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("com.lonar.vendor.vendorportal"))
                .build();
            }
*/
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("com.lonar.vendor.vendorportal"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My REST API", //title
                "Some custom description of API.", //description
                "Version 1.0", //version
                "Terms of service", //terms of service URL
                new Contact("Bhanuka Dissanayake", "www.example.com", "myeaddress@company.com"),
                "https://www.apache.org/licenses/LICENSE-2.0", "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList()); // contact info
    }
    
}
/**
 * 
 */
package org.jpractice.swagger.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-21 16:35:17
 * @Description: TODO
 * @version V1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("org.jpractice.swagger.controller")).build();
    }

}

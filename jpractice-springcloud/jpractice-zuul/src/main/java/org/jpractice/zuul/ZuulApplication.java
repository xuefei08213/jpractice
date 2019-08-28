/**
 * 
 */
package org.jpractice.zuul;

import org.jpractice.zuul.filter.error.ExceptionHandlerFilter;
import org.jpractice.zuul.filter.error.InternalServerErrorFilter;
import org.jpractice.zuul.filter.pre.PreFilter;
import org.jpractice.zuul.post.PostFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-01-21 15:44:11
 * @Description: TODO
 * @version V1.0
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }

    // @Bean
    // public ErrorFilter errorFilter() {
    // return new ErrorFilter();
    // }

    @Bean
    public InternalServerErrorFilter internalServerErrorFilter(ProxyRequestHelper helper) {
        return new InternalServerErrorFilter(helper);
    }

    @Bean
    public ExceptionHandlerFilter exceptionHandlerFilter(ProxyRequestHelper helper) {
        return new ExceptionHandlerFilter(helper);
    }

    @Bean(name = "error")
    public View defaultErrorView() {
        return DefaultView.defaultErrorView;
    }

}

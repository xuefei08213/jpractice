/**
 * 
 */
package org.jpractice.springboot.conditional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import brave.sampler.Sampler;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-17 05:46:15
 * @Description: TODO
 * @version V1.0
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class JpracticeApplication {

    @Bean
    public Sampler sampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpracticeApplication.class, args);
    }
}

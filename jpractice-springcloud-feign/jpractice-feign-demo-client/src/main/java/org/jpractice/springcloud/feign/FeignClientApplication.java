/**
 * 
 */
package org.jpractice.springcloud.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-03 17:30:39
 * @Description: TODO
 * @version V1.0
 */
@SpringBootApplication
@EnableFeignClients({ "org.jpractice" })
@EnableCaching
public class FeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignClientApplication.class, args);
    }



}

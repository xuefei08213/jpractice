/**
 * 
 */
package org.jpractice.springcloud.feign;

import org.jpractice.feign.demo.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-03 19:20:45
 * @Description: TODO
 * @version V1.0
 */
@FeignClient(name = "demoFeignClient", url = "http://localhost:8080", fallback = HystrixClientFallback.class)
public interface DemoFeignClient {

    @RequestMapping("/user/{id}")
    public User getUserById(@PathVariable(name = "id") String id);

}

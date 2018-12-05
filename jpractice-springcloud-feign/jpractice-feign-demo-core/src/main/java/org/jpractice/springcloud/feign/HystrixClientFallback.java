/**
 * 
 */
package org.jpractice.springcloud.feign;

import org.jpractice.feign.demo.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-03 21:47:22
 * @Description: TODO
 * @version V1.0
 */
@Component
public class HystrixClientFallback implements DemoFeignClient {

    @Override
    public User getUserById(String id) {
        User user = new User();
        user.setId("2");
        user.setName("error");
        return user;
    }

}

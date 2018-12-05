/**
 * 
 */
package org.jpractice.springcloud.feign;

import org.jpractice.feign.demo.entity.User;

import feign.hystrix.FallbackFactory;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-03 22:27:21
 * @Description: TODO
 * @version V1.0
 */
public class HystrixClientFallbackFactory implements FallbackFactory<DemoFeignClient> {

    @Override
    public DemoFeignClient create(Throwable throwable) {
        // TODO Auto-generated method stub
        return new DemoFeignClient() {

            @Override
            public User getUserById(String id) {
                User user = new User();
                return new User();
            }
        };
    }

}

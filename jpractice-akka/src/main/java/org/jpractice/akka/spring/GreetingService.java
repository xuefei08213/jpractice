/**
 * 
 */
package org.jpractice.akka.spring;

import org.springframework.stereotype.Component;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-27 09:13:24
 * @Description: TODO
 * @version V1.0
 */
@Component
public class GreetingService {

    public String greet(String name) {
        return "Hello, " + name;
    }
}

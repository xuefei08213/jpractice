/**
 * 
 */
package org.jpractice.zuul;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-01-21 18:42:19
 * @Description: TODO
 * @version V1.0
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public void test() {
        throw new BaseRuntimeException("sss");
    }

}

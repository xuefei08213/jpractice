/**
 * 
 */
package org.jpractice.spring.session;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-11-30 11:35:05
 * @Description: TODO
 * @version V1.0
 */
@RestController
public class SessionController {

    @RequestMapping("/")
    public String helloAdmin(HttpServletRequest request) {
        request.getSession();
        return "hello admin";
    }

}

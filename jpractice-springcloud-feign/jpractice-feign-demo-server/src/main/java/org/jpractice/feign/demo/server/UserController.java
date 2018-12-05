/**
 * 
 */
package org.jpractice.feign.demo.server;

import java.util.ArrayList;
import java.util.List;

import org.jpractice.feign.demo.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-03 19:33:18
 * @Description: TODO
 * @version V1.0
 */
@RestController
public class UserController {

    @RequestMapping("/user/{id}")
    public User getUserById(@PathVariable(name = "id") String userId) {

        System.out.println(userId);
        User user = new User();
        user.setId("1");
        user.setName("xuefei");
        user.setPhone("15951666874");

        return user;
    }

    @RequestMapping("/user/all")
    public List<User> getAllUser() {
        User user = new User();
        user.setId("1");
        user.setName("xuefei");
        user.setPhone("15951666874");
        List<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }
}

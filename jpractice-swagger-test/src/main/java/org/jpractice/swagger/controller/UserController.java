/**
 * 
 */
package org.jpractice.swagger.controller;

import org.jpractice.swagger.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-21 16:30:37
 * @Description: TODO
 * @version V1.0
 */
@RestController
@RequestMapping("/jpractice/user")
public class UserController {

    @GetMapping("/list")
    public void list() {

    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {

    }

}

/**
 * 
 */
package org.jpractice.springboot.h2;

import org.jpractice.springboot.h2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-09-10 18:39:41
 * @Description: TODO
 * @version V1.0
 */
@SpringBootApplication
@RestController
public class EmbeddedH2DemoApp implements CommandLineRunner {

    @Autowired
    H2CommadProcessor commadProcessor;

    public static void main(String[] args) {
        SpringApplication.run(EmbeddedH2DemoApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        commadProcessor.create();
    }

    @RequestMapping("/insert")
    public void insert() {
        User user = new User();
        user.setId("001");
        user.setName("xuefei");
        user.setAge(28);
        commadProcessor.insert(user);
    }
}

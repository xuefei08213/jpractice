/**
 * 
 */
package org.jpractice.springcloud.feign;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jpractice.feign.demo.entity.User;
import org.jpractice.springcloud.feign.caffeine.MusicService;
import org.jpractice.springcloud.feign.caffeine.MusicServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-03 19:44:43
 * @Description: TODO
 * @version V1.0
 */
@RestController
public class UserController {

    private Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private DemoFeignClient demoFeignClient;

    @Autowired
    private MusicService musicService;

    @RequestMapping("test")
    public User getUserById() {
        return demoFeignClient.getUserById("1");
    }

    @SuppressWarnings("rawtypes")
    @RequestMapping("testAll")
    public List<User> getAllUser(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://localhost:8080/user/all",
                List.class);
        return responseEntity.getBody();

    }

    @RequestMapping("caffeine")
    public void play() {
        logger.info("Spring Boot Caffeine Caching Example Configuration");

        play("trombone");
        // play("guitar");
        play("trombone");
        // play("bass");
        play("trombone");
    }

    private void play(String instrument) {
        logger.info("Calling: " + MusicServiceIml.class.getSimpleName() + ".play(\"" + instrument + "\");");
        musicService.play(instrument);
    }

    @RequestMapping("claerCaffeine")
    public void claerCaffeine() {
        logger.info("claer Caffeine");
        musicService.clearCache();
    }
}
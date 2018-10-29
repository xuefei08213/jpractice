/**
 * 
 */
package org.jpractice.akka.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import akka.actor.ActorSystem;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-27 10:52:58
 * @Description: TODO
 * @version V1.0
 */
@Configuration
@ComponentScan
public class AppConfiguration {

    @Bean
    public ActorSystem actorSystem() {
        ActorSystem system = ActorSystem.create("akka-spring-demo");
        return system;
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingService();
    }

    @Bean
    public SpringExtension springExtension() {
        return new SpringExtension();
    }

    @Bean
    public SpringExt springExt(ActorSystem actorSystem, SpringExtension springExtension, ApplicationContext appCtx) {
        SpringExt springExt = springExtension.get(actorSystem);
        springExt.initialize(appCtx);
        return springExt;
    }

}

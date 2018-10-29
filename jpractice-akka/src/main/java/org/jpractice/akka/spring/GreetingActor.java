/**
 * 
 */
package org.jpractice.akka.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import akka.actor.UntypedActor;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-25 16:15:56
 * @Description: TODO
 * @version V1.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GreetingActor extends UntypedActor {

    @Autowired
    private GreetingService greetingService;

    @Override
    public void onReceive(Object message) {
        if (message instanceof Greet) {
            String name = ((Greet) message).getName();
            getSender().tell(greetingService.greet(name), getSelf());
        } else {
            unhandled(message);
        }
    }

    public static class Greet {

        private String name;

        public String getName() {
            return name;
        }

        public Greet(String name) {
            this.name = name;
        }

    }

}

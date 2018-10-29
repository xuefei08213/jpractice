/**
 * 
 */
package org.jpractice.akka.spring;

import static akka.pattern.Patterns.ask;

import java.util.concurrent.TimeUnit;

import org.jpractice.akka.spring.GreetingActor.Greet;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.FiniteDuration;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-29 14:28:13
 * @Description: TODO
 * @version V1.0
 */
@ContextConfiguration(classes = AppConfiguration.class)
public class SpringAkkaIntegrationTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private ActorSystem system;

    @Autowired
    private SpringExtension springExtension;

    @Test
    public void whenCallingGreetingActor_thenActorGreetsTheCaller() throws Exception {
        ActorRef greeter = system.actorOf(springExtension.get(system).props("greetingActor"), "greeter");

        FiniteDuration duration = FiniteDuration.create(10, TimeUnit.SECONDS);
        Timeout timeout = Timeout.durationToTimeout(duration);

        Future<Object> result = ask(greeter, new Greet("John"), timeout);

        Assert.assertEquals("Hello, John", Await.result(result, duration));
    }

}

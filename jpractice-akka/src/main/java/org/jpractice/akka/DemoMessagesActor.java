/**
 * 
 */
package org.jpractice.akka;

import akka.actor.AbstractLoggingActor;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-24 15:57:26
 * @Description: TODO
 * @version V1.0
 */
public class DemoMessagesActor extends AbstractLoggingActor {

    static public class Greeting {
        private final String from;

        public Greeting(String from) {
            this.from = from;
        }

        public String getGreeter() {
            return from;
        }
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Greeting.class, g -> {
            log().info("I was greeted by {}", g.getGreeter());
        }).build();
    }

}

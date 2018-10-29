/**
 * 
 */
package org.jpractice.akka;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-24 08:38:41
 * @Description: TODO
 * @version V1.0
 */
public class MyActor extends AbstractActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    @Override
    public Receive createReceive() {

        return receiveBuilder().match(String.class, s -> {
            log.info("Received String message: {}", s);
        }).matchAny(o -> log.info("received unknown message")).build();
    }

}

/**
 * 
 */
package org.jpractice.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-24 16:03:06
 * @Description: TODO
 * @version V1.0
 */
public class FirstActor extends AbstractActor {

    final ActorRef child = getContext().actorOf(Props.create(MyActor.class), "myChild");

    @Override
    public Receive createReceive() {
        return receiveBuilder().matchAny(x -> getSender().tell(x, getSelf())).build();
    }

}

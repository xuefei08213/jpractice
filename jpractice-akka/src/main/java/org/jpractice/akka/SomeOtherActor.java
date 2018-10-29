/**
 * 
 */
package org.jpractice.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-24 15:07:16
 * @Description: TODO
 * @version V1.0
 */
public class SomeOtherActor extends AbstractActor {

    ActorRef demoActor = getContext().actorOf(DemoActor.props(42), "demo");

    /* (non-Javadoc)
     * @see akka.actor.AbstractActor#createReceive()
     */
    @Override
    public Receive createReceive() {
        // TODO Auto-generated method stub
        return null;
    }

}

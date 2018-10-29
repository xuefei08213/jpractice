/**
 * 
 */
package org.jpractice.akka;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-24 15:03:27
 * @Description: TODO
 * @version V1.0
 */
public class DemoActor extends AbstractActor {

    /**
     * Create Props for an actor of this type.
     * 
     * @param magicNumber
     *            The magic number to be passed to this actor’s constructor.
     * @return a Props for creating this actor, which can then be further configured
     *         (e.g. calling `.withDispatcher()` on it)
     */
    static Props props(Integer magicNumber) {
        // You need to specify the actual type of the returned actor
        // since Java 8 lambdas have some runtime type information erased
        return Props.create(DemoActor.class, () -> new DemoActor(magicNumber));
    }

    private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    private final Integer magicNumber;

    public DemoActor(Integer magicNumber) {
        this.magicNumber = magicNumber;
    }

    /* (non-Javadoc)
     * @see akka.actor.AbstractActor#createReceive()
     */
    @Override
    public Receive createReceive() {
        // TODO Auto-generated method stub
        return receiveBuilder().match(Integer.class, i -> {
            log.info(magicNumber.toString());
            getSender().tell(i + magicNumber, getSelf());
        }).build();
    }

}

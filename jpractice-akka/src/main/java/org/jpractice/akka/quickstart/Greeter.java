package org.jpractice.akka.quickstart;

import org.jpractice.akka.DependencyInjector;
import org.jpractice.akka.quickstart.Printer.Greeting;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

//#greeter-messages
public class Greeter extends AbstractActor {
//#greeter-messages
  static public Props props(String message, ActorRef printerActor) {
    return Props.create(Greeter.class, () -> new Greeter(message, printerActor));
  }

  //#greeter-messages
  static public class WhoToGreet {
    public final String who;

    public WhoToGreet(String who) {
        this.who = who;
    }
  }

  static public class Greet {
    public Greet() {
    }
  }
  //#greeter-messages

  private final String message;
  private final ActorRef printerActor;
    private final ActorRef demoActor = getContext().actorOf(Props.create(DependencyInjector.class, "1", "demoActor"),
            "demoActor11");
  private String greeting = "";

  public Greeter(String message, ActorRef printerActor) {
    this.message = message;
    this.printerActor = printerActor;
  }

  @Override
  public Receive createReceive() {
    return receiveBuilder()
        .match(WhoToGreet.class, wtg -> {
          this.greeting = message + ", " + wtg.who;
        })
        .match(Greet.class, x -> {
          //#greeter-send-message
          printerActor.tell(new Greeting(greeting), getSelf());
                    demoActor.tell(11, getSelf());
          //#greeter-send-message
                }).match(Integer.class, x -> System.out.println(x))
        .build();
  }
//#greeter-messages
}
//#greeter-messages

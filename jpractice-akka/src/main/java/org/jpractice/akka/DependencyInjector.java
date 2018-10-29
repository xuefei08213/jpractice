/**
 * 
 */
package org.jpractice.akka;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-24 16:23:05
 * @Description: TODO
 * @version V1.0
 */
public class DependencyInjector implements IndirectActorProducer {

    final Object applicationContext;
    final String beanName;

    public DependencyInjector(Object applicationContext, String beanName) {
        this.applicationContext = applicationContext;
        this.beanName = beanName;
    }

    @Override
    public Class<? extends Actor> actorClass() {
        return DemoActor.class;
    }

    @Override
    public Actor produce() {
        return new DemoActor(Integer.parseInt((String) applicationContext));
    }

}

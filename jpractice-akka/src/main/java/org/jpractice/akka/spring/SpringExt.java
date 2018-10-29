/**
 * 
 */
package org.jpractice.akka.spring;

import org.springframework.context.ApplicationContext;

import akka.actor.Extension;
import akka.actor.Props;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-29 15:02:11
 * @Description: TODO
 * @version V1.0
 */
public class SpringExt implements Extension {
    private volatile ApplicationContext applicationContext;

    public void initialize(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Props props(String actorBeanName) {
        return Props.create(SpringActorProducer.class, applicationContext, actorBeanName);
    }
}

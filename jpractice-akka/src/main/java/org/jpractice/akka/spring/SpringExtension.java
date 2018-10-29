/**
 * 
 */
package org.jpractice.akka.spring;

import akka.actor.AbstractExtensionId;
import akka.actor.ExtendedActorSystem;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-27 09:15:40
 * @Description: TODO
 * @version V1.0
 */
public class SpringExtension extends AbstractExtensionId<SpringExt> {

    @Override
    public SpringExt createExtension(ExtendedActorSystem system) {
        return new SpringExt();
    }

}

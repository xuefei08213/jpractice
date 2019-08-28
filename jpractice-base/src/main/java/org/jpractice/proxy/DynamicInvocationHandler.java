/**
 * 
 */
package org.jpractice.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-27 10:45:15
 * @Description: TODO
 * @version V1.0
 */
public class DynamicInvocationHandler implements InvocationHandler {

    // private static Logger LOGGER =
    // LoggerFactory.getLogger(DynamicInvocationHandler.class);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub
        System.out.println(String.format("Invoked method: %s", method.getName()));
        return null;
    }

}

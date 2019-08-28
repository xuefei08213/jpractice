/**
 * 
 */
package org.jpractice.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-27 10:57:20
 * @Description: TODO
 * @version V1.0
 */
public class TimingDynamicInvocationHandler implements InvocationHandler {

    private final Map<String, Method> methods = new HashMap<>();
    private Object target;

    public TimingDynamicInvocationHandler(Object target) {
        this.target = target;

        for (Method method : target.getClass().getDeclaredMethods()) {
            this.methods.put(method.getName(), method);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.nanoTime();
        Object result = methods.get(method.getName()).invoke(target, args);
        long elapsed = System.nanoTime() - start;

        // LOGGER.info("Executing {} finished in {} ns", method.getName(), elapsed);

        return result;
    }

}

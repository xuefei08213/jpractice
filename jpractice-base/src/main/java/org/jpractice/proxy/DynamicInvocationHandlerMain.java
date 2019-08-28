/**
 * 
 */
package org.jpractice.proxy;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-27 10:49:13
 * @Description: TODO
 * @version V1.0
 */
public class DynamicInvocationHandlerMain {

    public static void main(String[] args) {
        Map proxyInstance = (Map) Proxy.newProxyInstance(DynamicInvocationHandler.class.getClassLoader(),
                new Class[] { Map.class },
                new DynamicInvocationHandler());
        proxyInstance.put("aa", "aa");
    }

}

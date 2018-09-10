/**
 * 
 */
package org.jpratice.constructors;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-09-03 07:15:15
 * @Description: TODO
 * @version V1.0
 */
public class GuardedIDField implements HasID {

    private static AtomicInteger counter = new AtomicInteger();
    private int id = counter.getAndAdd(1);

    public int getID() {
        return id;
    }

    public static void main(String[] args) {
        IDChecker.test(GuardedIDField::new);
    }
}

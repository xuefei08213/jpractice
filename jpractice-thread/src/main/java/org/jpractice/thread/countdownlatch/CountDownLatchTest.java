/**
 * 
 */
package org.jpractice.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-26 12:29:58
 * @Description: TODO
 * @version V1.0
 */
public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(1);
                countDownLatch.countDown();

                System.out.println(2);
                countDownLatch.countDown();
            }
        }).start();

        countDownLatch.await();
        System.out.println("3");
    }

}

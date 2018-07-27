/**
 * 
 */
package org.jpractice.java8.stream.thread;

import static org.jpractice.java8.stream.thread.Util.delay;
/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-26 07:17:11
 * @Description: TODO
 * @version V1.0
 */
public class ExchangeService {
    public enum Money {
        USD(1.0), EUR(1.35387), GBP(1.69715), CAD(.92106), MXN(.07683);

        private final double rate;

        Money(double rate) {
            this.rate = rate;
        }
    }

    public static double getRate(Money source, Money destination) {
        return getRateWithDelay(source, destination);
    }

    private static double getRateWithDelay(Money source, Money destination) {
        delay();
        return destination.rate / source.rate;
    }
}

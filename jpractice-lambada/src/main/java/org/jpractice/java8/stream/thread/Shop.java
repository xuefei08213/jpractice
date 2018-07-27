/**
 * 
 */
package org.jpractice.java8.stream.thread;

import static org.jpractice.java8.stream.thread.Util.delay;
import static org.jpractice.java8.stream.thread.Util.format;

import java.util.Random;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-18 06:44:23
 * @Description: TODO
 * @version V1.0
 */
public class Shop {

    private final String name;

    private final Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public String getName() {
        return name;
    }


    /**
     * 获取商品价格
     * 
     * @param product
     * @return
     */
    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return name + ":" + price + ":" + code;
    }



    /**
     * 查询商店中某个商品的价格
     * 
     * @param product
     * @return
     */
    private double calculatePrice(String product) {
        delay();
        return format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }


}

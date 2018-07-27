/**
 * 
 */
package org.jpractice.java8.stream.thread;

import org.jpractice.java8.stream.thread.Discount.Code;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-25 06:58:41
 * @Description: TODO
 * @version V1.0
 */
public class Quote {

    private final String shopName;
    private final double price;
    private final Discount.Code discountCode;

    public Quote(String shopName, double price, Code discountCode) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }

    public static Quote parse(String s) {
        String[] split = s.split(":");
        String shopName = split[0];
        double price = Double.parseDouble(split[1]);
        Discount.Code discountCode = Discount.Code.valueOf(split[2]);
        return new Quote(shopName, price, discountCode);
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }

}

/**
 * 
 */
package org.jpractice.java8.stream.exercise;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-05 19:13:29
 * @Description: TODO
 * @version V1.0
 */
public class Transaction {

    private Trader trader;

    private int year;

    private int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" + this.trader + "," + "year:" + this.year + "," + "value:" + this.value;
    }

}

/**
 * 
 */
package org.jpractice.generic;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-13 07:01:07
 * @Description: TODO
 * @version V1.0
 */
public class PairWithCompare<T extends Comparable<T>> {

    private T first;

    private T second;

    public PairWithCompare() {
        this.first = null;
        this.second = null;
    }

    public PairWithCompare(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public static void main(String[] args) {
        PairWithCompare<String> pair = new PairWithCompare<>();
        pair.setFirst("1");
        pair.setSecond("2");

        String s = pair.getFirst();
    }

}

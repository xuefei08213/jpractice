/**
 * 
 */
package org.jpractice.generic;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-11 23:56:39
 * @Description: TODO
 * @version V1.0
 */
public class Pair<T> {

    private T first;

    private T second;

    public Pair() {
        this.first = null;
        this.second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    // public boolean equals(T value) {
    // return first.equals(value) && second.equals(value);
    // }

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

        Pair<String> pair = new Pair<>();
        pair.setFirst("1");
        pair.setSecond("2");

        String s = pair.getFirst();
    }

}

/**
 * 
 */
package org.jpractice.generic;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-12 22:47:38
 * @Description: TODO
 * @version V1.0
 */
public class PairWithObject {

    private Object first;

    private Object second;

    public PairWithObject() {
        this.first = null;
        this.second = null;
    }

    public PairWithObject(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return first;
    }

    public void setFirst(Object first) {
        this.first = first;
    }

    public Object getSecond() {
        return second;
    }

    public void setSecond(Object second) {
        this.second = second;
    }

    public static void main(String[] args) {
        PairWithObject pairWithObject = new PairWithObject();
        pairWithObject.setFirst("1");
        pairWithObject.setSecond("2");
        String s = (String) pairWithObject.getFirst();
    }

}

/**
 * 
 */
package org.jpractice.generic;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-18 11:29:13
 * @Description: TODO
 * @version V1.0
 */
public class GenericArrayList<E> {

    private Object[] elementData;

    private int mod = 0;

    public GenericArrayList() {
        elementData = new Object[8];
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elementData[index];
    }

    public void add(E e) {
        elementData[mod] = e;
        mod++;
    }

    public static void main(String[] args) {
        GenericArrayList<String> arrayList = new GenericArrayList<>();
        arrayList.add("a");
        arrayList.add("b");

        String s = arrayList.get(0);
        System.out.println(s);
    }
}

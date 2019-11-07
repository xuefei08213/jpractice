/**
 * 
 */
package org.jpractice.algorithm.priorityqueue;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-10-15 06:39:20
 * @Description: TODO
 * @version V1.0
 */
public class UnsortedMaxPQByArray<Key extends Comparable<Key>> {

    Key[] keys;

    int size = 0;

    @SuppressWarnings("unchecked")
    public UnsortedMaxPQByArray(int capacity) {
        keys = (Key[]) new Comparable[capacity];
    }

    // insert a key into the priority queue
    void insert(Key v) {
        keys[size++] = v;
    }

    // return and remove the largest key
    Key delMax() {

        Key max;
        if (size == 0) {
            throw new RuntimeException("the pq is empty");
        }

        int maxIndex = 0;
        for (int i = 1; i < size; i++) {
            if (keys[maxIndex].compareTo(keys[i]) < 0) {
                maxIndex = i;
            }
        }
        // 将最大的值换到数组的末尾以保持删除元素之后数据的连续性
        exec(maxIndex, size - 1);
        max = keys[--size];
        keys[size] = null;
        return max;
    }

    private void exec(int srcIndex, int targetIndex) {

        Key src = keys[srcIndex];
        keys[srcIndex] = keys[targetIndex];
        keys[targetIndex] = src;
    }

    // is the priority queue empty?
    boolean isEmpty() {
        return size == 0;
    }

    Key max() {
        int maxIndex = 0;
        for (int i = 1; i < size; i++) {
            if (keys[maxIndex].compareTo(keys[i]) < 0) {
                maxIndex = i;
            }
        }
        Key max = keys[maxIndex];
        return max;

    }

    int size() {
        return size;
    }

    void print() {
        for (int i = 0; i < keys.length; i++) {
            System.out.println(keys[i]);
        }
    }

    public static void main(String[] args) {

        UnsortedMaxPQByArray<Integer> maxPQByArray = new UnsortedMaxPQByArray<>(5);
        maxPQByArray.insert(1);
        // maxPQByArray.insert(10);
        // maxPQByArray.insert(5);
        // maxPQByArray.insert(6);
        // maxPQByArray.insert(3);

        // maxPQByArray.print();
        //
        // System.out.println("max element is :" + maxPQByArray.max());

        System.out.println("delete max element is :" + maxPQByArray.delMax());

        maxPQByArray.print();

        // System.out.println("delete max element is :" + maxPQByArray.delMax());
        //
        // maxPQByArray.print();
        //
        // System.out.println("delete max element is :" + maxPQByArray.delMax());
        //
        // maxPQByArray.print();
        //
        // System.out.println("delete max element is :" + maxPQByArray.delMax());
        //
        // maxPQByArray.print();
    }

}

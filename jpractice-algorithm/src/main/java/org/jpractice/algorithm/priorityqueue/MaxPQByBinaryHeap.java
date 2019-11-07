/**
 * 
 */
package org.jpractice.algorithm.priorityqueue;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-10-17 06:21:24
 * @Description: TODO
 * @version V1.0
 */
public class MaxPQByBinaryHeap<Key extends Comparable<Key>> {

    Key[] keys;

    int num = 0;

    public MaxPQByBinaryHeap(int capacity) {
        keys = (Key[]) new Comparable[capacity + 1];
    }

    // insert a key into the priority queue
    void insert(Key v) {
        keys[++num] = v;
        swim(num);
    }


    private void swim(int index) {

        // index / 2 为父元素索引，如果父元素小于该元素则互换位置
        if (index > 1 && less(keys[index / 2], keys[index])) {
            exec(index / 2, index);
            swim(index / 2);
        }
    }

    // return and remove the largest key
    Key delMax() {
        Key max = keys[1];
        exec(1, num--);
        sink(1);

        keys[num + 1] = null;

        return max;
    }

    void sink(int index) {

        // index * 2 为子元素的索引，用于判断是否还有子元素
        while (index * 2 <= num) {
            int j = index * 2;

            // 因为子元素有两个，父元素只跟最大的子元素比较
            if (j < num && less(keys[j], keys[j + 1])) {
                j++;
            }

            // 如果子元素小于最大的子元素则两者互换位置
            if (!less(keys[index], keys[j])) {
                break;
            } else {
                exec(index, j);
                index = j;
            }
        }
    }

    private boolean less(Key src, Key targrt) {

        return src.compareTo(targrt) < 0;
    }

    private void exec(int srcIndex, int targetIndex) {
        Key src = keys[srcIndex];
        keys[srcIndex] = keys[targetIndex];
        keys[targetIndex] = (Key) src;
    }

    void print() {
        for (int i = 1; i < num + 1; i++) {
            System.out.print(keys[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxPQByBinaryHeap<Integer> maxPQByBinaryHeap = new MaxPQByBinaryHeap<>(6);
        maxPQByBinaryHeap.insert(1);

        maxPQByBinaryHeap.insert(2);

        maxPQByBinaryHeap.insert(3);

        maxPQByBinaryHeap.insert(4);

        maxPQByBinaryHeap.delMax();

        maxPQByBinaryHeap.print();
    }


}

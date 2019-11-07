package org.jpractice.algorithm.priorityqueue;

public class SortedMaxPQByArray<Key extends Comparable<Key>> {

    Key[] keys;

    int size = 0;

    @SuppressWarnings("unchecked")
    public SortedMaxPQByArray(int capacity) {
        keys = (Key[]) new Comparable[capacity];
    }

    // insert a key into the priority queue
    void insert(Key key) {
        int i = size - 1;
        while (i >= 0 && (less(key, keys[i]))) {
            keys[i + 1] = keys[i];
            i--;
        }
        keys[i + 1] = key;
        size++;
    }

    private boolean less(Key src, Key targrt) {
        return src.compareTo(targrt) < 0;
    }

    // return and remove the largest key
    Key delMax() {
        Key max = keys[size - 1];
        keys[size - 1] = null;
        return max;
    }

    // is the priority queue empty?
    boolean isEmpty() {
        return size == 0;
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

        SortedMaxPQByArray<Integer> maxPQByArray = new SortedMaxPQByArray<>(5);
        maxPQByArray.insert(1);
        maxPQByArray.insert(10);
        maxPQByArray.insert(5);
        // maxPQByArray.insert(6);
        // maxPQByArray.insert(3);

        // maxPQByArray.print();
        //
        // System.out.println("max element is :" + maxPQByArray.max());

        // System.out.println("delete max element is :" + maxPQByArray.delMax());

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

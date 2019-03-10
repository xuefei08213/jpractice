/**
 * 
 */
package org.jpractice.algorithm.priorityqueue;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-02-10 18:01:36
 * @Description: TODO
 * @version V1.0
 */
public class UnorderedMaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;

    private int N;

    public UnorderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key x) {
        pq[N++] = x;
    }

    public Key delMax() {
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (less(max, i)) {
                max = i;
            }
        }
        exch(max, N - 1);
        return pq[--N];
    }

    private boolean less(int i, int m) {
        if (pq[i].compareTo(pq[m]) < 0) {
            return true;
        }
        return false;
    }

    private void exch(int i, int m) {
        Key t = pq[i];
        pq[i] = pq[m];
        pq[m] = t;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        UnorderedMaxPQ maxPQ = new UnorderedMaxPQ<>(5);
        maxPQ.insert(1);
        maxPQ.insert(12);
        maxPQ.insert(3);
        maxPQ.insert(4);
        maxPQ.insert(5);
        System.out.println(maxPQ.delMax());

        // for (int i = 0; i < maxPQ.N; i++) {
        // System.out.println();
        // }
    }

}

/**
 * 
 */
package org.jpractice.algorithm.priorityqueue;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-02-15 06:50:37
 * @Description: TODO
 * @version V1.0
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;

    private int N;

    @SuppressWarnings("unchecked")
    public MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N + 1] = null;
        return max;
    }

    /**
     * Exchange key in child with key in parent .
     * Repeat until heap order restored.
     * 
     * @param k
     */
    private void swim(int k) {
        // parent of node k is at k/2
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    /**
     * Exchange key in parent with key in larger child Repeat until heap order
     * restored
     * 
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
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

    private void print() {
        for (int i = 1; i <= N; i++) {
            System.out.println(pq[i]);
        }
    }

    public static void main(String[] args) {
        MaxPQ maxPQ = new MaxPQ<>(5);
        maxPQ.insert(1);
        maxPQ.insert(12);
        maxPQ.insert(3);
        maxPQ.insert(4);
        maxPQ.insert(5);
        maxPQ.print();
        System.out.println(maxPQ.delMax());
        maxPQ.print();

    }

}

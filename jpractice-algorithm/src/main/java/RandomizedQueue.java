import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 
 */

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-01-15 21:06:37
 * @Description: TODO
 * @version V1.0
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] a;

    private int n;

    public RandomizedQueue() {
        this.a = (Item[]) new Object[2];
        this.n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        if (n == a.length) {
            resize(2 * a.length);
        }

        if (n == 0) {
            a[n++] = item;
            return;
        }

        int randomIndex = StdRandom.uniform(n);
        Item temp = a[randomIndex];
        a[randomIndex] = item;
        a[n++] = temp;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (n == a.length / 4) {
            resize(a.length / 2);
        }
        int randomIndex = StdRandom.uniform(n);
        Item item = a[randomIndex];
        a[randomIndex] = a[--n];
        a[n] = null; // to prevent loitering
        return item;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();
        return a[StdRandom.uniform(n)];
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {

        private int i;
        private int[] randomIndices;

        public ArrayIterator() {
            i = 0;
            randomIndices = new int[n];
            for (int j = 0; j < n; j++) {
                randomIndices[j] = j;
            }
            StdRandom.shuffle(randomIndices);
        }

        @Override
        public boolean hasNext() {
            return i < n;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return a[randomIndices[i++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}

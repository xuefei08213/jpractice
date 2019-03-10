import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 */

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-01-14 19:33:08
 * @Description: TODO
 * @version V1.0
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first;

    private Node last;

    private int size;

    public Deque() {
        size = 0;
    }

    // is the deque empty
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {

        if (null == item) {
            throw new IllegalArgumentException();
        }

        Node oldFirst = first;

        first = new Node();
        first.item = item;
        first.next = oldFirst;

        if (null == last) {
            last = first;
        } else {
            first.next.prev = first;
        }
        size++;

    }

    // add the item to the end
    public void addLast(Item item) {
        if (null == item) {
            throw new IllegalArgumentException();
        }
        Node oldLast = last;

        last = new Node();
        last.item = item;
        last.prev = oldLast;

        if (null == first) {
            first = last;
        } else {
            last.prev.next = last;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Item item = first.item;
        size--;
        if (isEmpty()) {
            last = null;
            first = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        return item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        Item item = last.item;
        size--;
        if (isEmpty()) {
            last = null;
            first = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new ListIterator();
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }


}

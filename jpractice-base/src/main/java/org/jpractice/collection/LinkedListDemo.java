/**
 * 
 */
package org.jpractice.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-09-29 07:02:07
 * @Description: TODO
 * @version V1.0
 */
public class LinkedListDemo {

    public void add() {
        List<String> staff = new LinkedList<>();

        // add方法将元素添加到集合的最后
        staff.add("chengaofeng");
        staff.add("xuefei");
        staff.add("miaoyun");
        printList(staff);

        LinkedListDemo demo = new LinkedListDemo();
        demo.addEnd(staff, "aa");
        printList(staff);

        demo.set(staff, 2, "hhh");
        printList(staff);

        // 用ListIterator插入元素
        ListIterator<String> listIterator = staff.listIterator(0);
        listIterator.next(); // 越过第一个元素
        listIterator.add("miaolei"); // 添加到迭代器当前位置之前
        printList(staff);

        listIterator.previous();
        listIterator.add("wangmg");
        printList(staff);
    }

    /**
     * 在表头插入元素
     * 
     * @param list
     * @param item
     */
    public void addHead(List<String> list, String item) {
        ListIterator<String> listIterator = list.listIterator();
        listIterator.add(item);
    }

    public void addEnd(List<String> list, String item) {

        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
        }
        listIterator.add(item);

        // ListIterator<String> listIterator = list.listIterator(list.size());
        // listIterator.add(item);
    }

    public void set(List<String> list, int index, String item) {
        ListIterator<String> listIterator = list.listIterator(index);
        listIterator.next();
        listIterator.set(item);
    }

    public void printList(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("========");
    }

    public static void main(String[] args) {

        LinkedListDemo linkedListDemo = new LinkedListDemo();
        linkedListDemo.add();

        // List<String> staff = new LinkedList<>();
        // staff.add("Amy");
        // staff.add("chengaofeng");
        // staff.add("xuefei");
        //
        // for (String name : staff) {
        // System.out.println(name);
        // }
        // System.out.println("========");
        //
        // Iterator<String> iterator = staff.iterator();
        // String first = iterator.next();
        // String second = iterator.next();
        // iterator.remove();
        // for (String name : staff) {
        // System.out.println(name);
        // }
        // System.out.println("========");
        //
        // staff.add("woodman");
        // for (String name : staff) {
        // System.out.println(name);
        // }
        // System.out.println("========");
        // /**
        // * Iterator没有add方法，
        // *
        // * 因为只有对自然有序的集合使用迭代器添加元素才有实际的意， 而Set中的元素完全是无序的
        // *
        // * 因此提供了ListIterator，它提供了add方法，但是这个add方法假定添加操作总会改变链表，因此不返回boolean类型
        // *
        // */
        // ListIterator<String> listIterator = staff.listIterator();
        // listIterator.add("miaoyun");
        // listIterator.next();
        // listIterator.next();
        // listIterator.add("miaolei");
        //
        // for (String name : staff) {
        // System.out.println(name);
        // }

    }

}

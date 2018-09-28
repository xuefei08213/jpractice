/**
 * 
 */
package org.jpractice.collection;

import java.util.Iterator;
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

    }

    public static void main(String[] args) {
        List<String> staff = new LinkedList<>();
        staff.add("Amy");
        staff.add("chengaofeng");
        staff.add("xuefei");

        for (String name : staff) {
            System.out.println(name);
        }
        System.out.println("========");

        Iterator<String> iterator = staff.iterator();
        String first = iterator.next();
        String second = iterator.next();
        iterator.remove();
        for (String name : staff) {
            System.out.println(name);
        }
        System.out.println("========");

        staff.add("woodman");
        for (String name : staff) {
            System.out.println(name);
        }
        System.out.println("========");
        /**
         * Iterator没有add方法，
         * 
         * 因为只有对自然有序的集合使用迭代器添加元素才有实际的意， 而Set中的元素完全是无序的
         * 
         * 因此提供了ListIterator，它提供了add方法，但是这个add方法假定添加操作总会改变链表，因此不返回boolean类型
         * 
         */
        ListIterator<String> listIterator = staff.listIterator();
        listIterator.add("miaoyun");
        listIterator.next();
        listIterator.next();
        listIterator.add("miaolei");

        for (String name : staff) {
            System.out.println(name);
        }

    }

}

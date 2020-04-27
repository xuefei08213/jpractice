/**
 * 
 */
package org.jpractice.algorithm;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2020-02-08 20:20:18
 * @Description: TODO
 * @version V1.0
 */
public class Leetcode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        boolean isCarry = false;

        while (l1 != null || l2 != null) {

            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int val = (val1 + val2);

            if (isCarry) {
                val += 1;
                isCarry = false;
            }
            curr.next = new ListNode(val % 10);
            if (val / 10 > 0) {
                isCarry = true;
            }

            curr = curr.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (isCarry) {
            curr.next = new ListNode(1);
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

        System.out.println(321 % 10);
        System.out.println(10 % 10);
        System.out.println(4 % 10);
        System.out.println(10 % 10);
        System.out.println(14 % 10);

        System.out.println(4 / 10);
        System.out.println(10 / 10);
        System.out.println(24 / 10);

        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode4.next = listNode3;

        ListNode listNode2 = new ListNode(2);
        listNode2.next = listNode4;

        ListNode _listNode4 = new ListNode(4);
        ListNode listNode6 = new ListNode(6);
        listNode6.next = _listNode4;

        ListNode listNode5 = new ListNode(5);
        listNode5.next = listNode6;

        Leetcode2 leetcode2 = new Leetcode2();

        leetcode2.addTwoNumbers(listNode2, listNode5);

        ListNode listNodeZero1 = new ListNode(0);
        ListNode listNodeZero2 = new ListNode(0);
        leetcode2.addTwoNumbers(listNodeZero1, listNodeZero2);

        ListNode listNodeFive1 = new ListNode(5);
        ListNode listNodeFive2 = new ListNode(5);

        leetcode2.addTwoNumbers(listNodeFive1, listNodeFive2);

        ListNode listNode1 = new ListNode(1);
        ListNode listNode8 = new ListNode(8);
        listNode1.next = listNode8;

        ListNode listNodeZero = new ListNode(0);

        leetcode2.addTwoNumbers(listNode1, listNodeZero);

    }

}

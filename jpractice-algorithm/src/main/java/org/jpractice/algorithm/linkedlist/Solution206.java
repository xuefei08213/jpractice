package org.jpractice.algorithm.linkedlist;

public class Solution206 {
    public ListNode reverseList(ListNode head) {

        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        ListNode node2 = new ListNode(2);

        ListNode node3 = new ListNode(3);

        ListNode node4 = new ListNode(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution206 solution206 = new Solution206();
        solution206.reverseList(head);

    }
}

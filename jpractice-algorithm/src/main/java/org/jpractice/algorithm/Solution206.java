package org.jpractice.algorithm;

public class Solution206 {
    public ListNode reverseList(ListNode head) {

        ListNode p1 = head;
        ListNode p2 = head.next;
        p1.next = null;
        while (p2 != null) {
            ListNode tmpNode = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmpNode;
        }
        return p1;
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

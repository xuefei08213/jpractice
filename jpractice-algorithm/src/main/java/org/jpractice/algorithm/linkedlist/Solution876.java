/**
 * 
 */
package org.jpractice.algorithm.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-09-11 21:59:14
 * @Description: TODO
 * @version V1.0
 */
public class Solution876 {

    public ListNode middleNode(ListNode head) {

        Map<Integer, ListNode> map = new HashMap<>();

        int count = 1;
        map.put(1, head);
        while (head.next != null) {
            count++;
            map.put(count, head.next);
            head = head.next;
        }
        return map.get((count / 2) + 1);
    }

    public static void main(String[] args) {
        System.out.println(5 / 2);
        System.out.println(5 % 2);
    }

}

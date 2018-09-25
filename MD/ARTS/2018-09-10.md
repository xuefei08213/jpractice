


## Alogrithom
### Problem:  [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/description/)
### Tags: 
### Difficulty: Easy
### Description
Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.

### Example

Example 1:

Input: [1,2,3,4,5]  
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).  
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.  

Example 2:  
Input: [1,2,3,4,5,6]. 
Output: Node 4 from this list (Serialization: [4,5,6]).  
Since the list has two middle nodes with values 3 and 4, we return the second one.

#### Solution
````java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
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
}
````


## Review
[Writing a High Level Design](https://medium.com/@david.vancouvering/writing-a-high-level-design-26280ee88480)

这篇文章写的是一个关于架构设计方面的思路以及注意点。

架构设计不包括数据库以及类等等详细设计，它只是提供了一个框架并指导开发细节。要努力做到一个架构设计能维持半年以上不偏离预期轨道。

关于架构设计可以按照下面的几步来完成：  
1.找出目前出现的问题以及需求列表，需求是以场景，用例以及验收标准来定义。在进行下一步之前，需要进行需求评审，并与客户达成一致。  
2.定义领域模型。从领域专家那里弄清楚领域模型是什么以及它们之间的关联关系。领域模型是后面设计的基础，它为产品开发者跟用户之间的清晰准确沟通奠定了基础。领域模型中的术语一定要使用中领域中规定的，不可以随意定义。  
3.需求跟领域模型之间是相辅相成的关系，需要使用需求来测试领域模型是否合理，领域模型也可以来影响需求。一定要做到持续跟用户沟通并更新领域模型。  
4.在领域模型定义完成之后，就需要开始布局实现设计的组件。组件的设计需要结合场景，用例以及领域驱动    
5.可以使用测试用例来练习领域模型以及组件。
6.异常情况的处理。对异常的情况的分析对设计能够产生更加深远的影响  
7.迭代。在实践的过程中你会发现领域模型和组件的错误（不合适），这就需要进行调整，并将问题反馈给专家。

## Technique

目前公司微服务使用的是docker，持续集成环境也是基于docker搭建的，这个星期的Technique主要是分享搭建这个持续集成环境的步骤，具体步骤放在了CSDN上[使用docker搭建持续集成(CI)环境](https://mp.csdn.net/postedit/82728236)

## Share

看了皓哥关于学习观点以及学习方法后感触颇深，对于我来说，那些都是精华部分，已经不能再做提取了。
但是看皓哥的文章的时候想起来以前看的一本书《刻意练习》，皓哥的文章就是对这本书中内容最好的实践，建立心理表征，进行刻意练习。

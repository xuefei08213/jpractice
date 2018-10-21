


## Alogrithom
### Problem:  [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/description/)
### Description
Reverse a singly linked list.

### Example

    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL

#### Solution
````java
public class Solution {
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
}
````


## Review
[The top data structures you should know for your next coding interview](https://medium.freecodecamp.org/the-top-data-structures-you-should-know-for-your-next-coding-interview-36af0831f5e3)

这篇文章主要讲的是8个数据结构的基本概念，基本操作以及面试时可能会问到的问题。

Arrays

+ Find the second minimum element of an array
+ First non-repeating integers in an array
+ Merge two sorted arrays
+ Rearrange positive and negative values in an array

Stacks

+ Evaluate postfix expression using a stack
+ Sort values in a stack
+ Check balanced parentheses in an expression

Queues

+ Implement stack using a queue
+ Reverse first k elements of a queue
+ Generate binary numbers from 1 to n using a queue


LinkedList

+ Reverse a linked list
+ Detect loop in a linked list
+ Return Nth node from the end in a linked list
+ Remove duplicates from a linked list

Graphs

+ Implement Breadth and Depth First Search
+ Check if a graph is a tree or not
+ Count number of edges in a graph
+ Find the shortest path between two vertices

Trees

+ Find the height of a binary tree
+ Find kth maximum value in a binary search tree
+ Find nodes at “k” distance from the root
+ Find ancestors of a given node in a binary tree

Trie

+ Count total number of words in Trie
+ Print all words stored in Trie
+ Sort elements of an array using Trie
+ Form words from a dictionary using Trie
+ Build a T9 dictionary

HashTable

+ Find symmetric pairs in an array
+ Trace complete path of a journey
+ Find if an array is a subset of another array
+ Check if given arrays are disjoint



## Technique
SpringBoot中的条件注解，以及在项目中用到的场景（部分）

@ConditionalOnClass  
@ConditionalOnMissingClass  

@ConditionalOnProperty  

@ConditionalOnBean  
@ConditionalOnMissingBean



@ConditionalOnProperty  
根据配置信息来判断Bean是否加载  

    假设现在需要开发一个数据接入接口（数据是通过文件来传输的），而不同的现场文件的格式不同，但是数据处理需要的属性是相同的。  也就是说除了解析文件这一步是不同的，后续数据的处理都相同。
    在这样的场景下，就可以设计一个解析文件的接口，针对每个现场完成不同的实现。在Bean的配置时加上@ConditionalOnProperty 注解，在现场部署时，只需要修改下属性就可以。

````java

    @Bean
    @ConditionalOnProperty(name = "province", havingValue = "default", matchIfMissing = true)
    public DataParser omsopDataParser() {
        return new OmsopDataParser();
    }

    @ConditionalOnProperty(name = "province", havingValue = "henan")
    @Bean
    public DataParser hnOmsopDataParser() {
        return new HNOmsopDataParser();
    }
    
````

@ConditionalOnResource  

@ConditionalOnWebApplication  
@ConditionalOnNotWebApplication

@ConditionalOnExpression


## Share

    在代码改造或者扩展时，一定要分析出不变和变化的部分，然后在进行改造和扩展。  
在上面的数据接入接口的场景中，变化的部分是文件的格式，不变的部分是后续的数据处理，因此我们只需要把不同格式的文件解析微相同的数据结构，保持后续的数据处理逻辑不变即可。    
但如果将文件解析为不同的数据结构，可能在解析时会很方便容易，但是后续的数据处理逻辑就会因为数据结构的不同变得非常的复杂，而且在针对数据做不同的处理时会大大的增加代码的层次结构以及代码阅读的难度。

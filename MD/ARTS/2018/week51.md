


## Alogrithom
### Problem:  [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)
### Description
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

**Note:**

+ The number of elements initialized in nums1 and nums2 are m and n respectively.
+ You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

### Example
**Input:**  
nums1 = [1,2,3,0,0,0], m = 3  
nums2 = [2,5,6],       n = 3

**Output:** [1,2,2,3,5,6]


#### Solution
````java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[nums1.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[k] = nums1[i];
                i++;
            } else {
                temp[k] = nums2[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < m) {
            temp[k] = nums1[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n) {
            temp[k] = nums2[j];
            j++;
            k++;
        }

        for (int h = 0; h < temp.length; h++) {
            nums1[h] = temp[h];
        }
    }
}
````


## Review
[Hystrix](https://github.com/Netflix/Hystrix/wiki)  
这篇文章是GitHub上关于Hystrix的介绍，主要从什么是Hystrix、Hystrix用来做什么、Hystrix解决了什么样的问题、Hystrix的设计原则、Hystrix如何达到它的目的这五个方面来阐述。
### 什么是Hystrix？
在分布式环境中，不可避免的，许多服务依赖项中的一些会异常。Hystrix是一个通过增加延迟容忍（latency tolerance）以及容错逻辑来帮助程序员控制分布式服务之间的交互的一个库。Hystrix通过隔离服务的访问点，阻止服务之间的级联故障以及提供后备(fallback)选项，所有的这些都可以提高系统的整体弹性。
### Hystrix用来做什么？
+ 通过第三方客户端库保护并控制访问依赖项的延迟和故障
+ 在复杂的分布式系统中停止级联故障
+ 快速失败（Fail Fast）并迅速恢复
+ 在可能的情况下，回退并降级
+ 实现近实时监控，警报和操作控制

### Hystrix解决了什么样的问题？
复杂分布式架构中的应用程序具有许多的依赖关系，每个依赖关系都有可能在某个时间点上不可避免的发生异常。如果主应用没有跟这些外部故障隔离，他也可能会发生异常。  
比如说，一个应用程序依赖了30个服务，每个服务的可用率为99.99%。可以计算出整体的可用为99.7%（99.99%的30次方），也就是说在10亿个请求中会有300万个失败的，另外即使所有的依赖服务都达到了预期的正常运行时间，每个月的停机时间也会超过2个小时（0.3*24*30）。但是现实情况要比这个要糟糕。  
即使所有的依赖关系都正常运行，如果没有为整个系统设置弹性，那么即使数十种服务中每个服务都有0.01%停机时间，也相当于每月停机一个小时。
当所有的都正常运行时，请求流会是下图这样：
![Philadelphia's Magic Gardens. This place was so cool!](images/soa-1-640.png "Philadelphia's Magic Gardens")





## Technique


## Share
分享一个不知道具体调用过程的时候，就好像filter这些，直接看代码有可能看不到（一般都出现在config文件里面）。在这样的情况，可以通过在确定的代码里面打断点，然后通过eclipse的debug的调用堆栈来确定调用过程，然后在诸逐个的分析源码。
    

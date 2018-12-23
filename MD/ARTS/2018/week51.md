


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
![](images/soa-1-640.png "所有的都正常运行时，请求流")
当后端服务中的一个变的延迟时，它可以阻塞整个用户请求：
![](images/soa-2-640.png "当后端服务中的一个变的延迟时，它可以阻塞整个用户请求")
在高流量的情况下，单个后端服务变的延迟可能导致所有服务器上的所有资源变的饱和。
![](images/soa-3-640.png "单个后端服务变的延迟可能导致所有服务器上的所有资源变的饱和")
当通过第三方客户端执行网络访问时，这些问题会加剧。因为这些第三方客户端就像是一个“黑匣子”，它隐藏了实现细节并且可以随时修改，并且每个客户端库的网络或资源配置都不同，并且通常情况下难以监控和更改。  
更糟糕的是依赖传递，这些依赖性之间存在昂贵的或容易出错的网络调用，而不会被应用程序显示调用。  
另外，网络连接失败或降级，服务或服务器宕机或变慢，新库或服务部署更改行为或性能特征，客户端库存在bug。所有这些代表了需要隔离和管理的故障和延迟。只有做到这样才能实现单个服务的故障不会影响整个应用的使用。

### Hystrix的设计原则？
+ 防止任何单个依赖项用尽所有容器（例如Tomcat）用户进程
+ 减轻负载并快速失败（fast-fail）而不是排队
+ 在可行的地方提供回退以保护用户免于失败
+ 使用隔离技术（例如bulkhead，swimlane，circuit breaker patterns（断路器模式））限制任何一个依赖的影响
+ 通过近实时指标，监控和警报优化发现时间

### Hystrix如何达到它的目的？
+ 将所有对外部系统的请求包含在HystrixCommand或者HystrixObservableCommand对象中，每个都在单独的线程中运行（这里采用的是命令模式）
+ 自定义超时阀值
+ 为每个依赖管理一个线程池或者信号，如果这个依赖的线程池满了，后面对这个依赖的请求会立刻被拒绝而不是排队
+ 量化成功、失败、超时和线程拒绝
+ 当对某个服务访问的错误比例超过一定的阀值，手动或自动的打开断路器以中断对这个服务的访问一段时间
+ 在发生请求失败、请求被拒绝、请求超时或者短路的情况，提供一个回退策略
+ 实时的监控以及实时的配置修改
![](images/soa-4-isolation-640.png "单个后端服务变的延迟可能导致所有服务器上的所有资源变的饱和")


## Technique

在程序中如果向定位内存溢出的问题，可以在容器启动的过程中加上下面的参数

	-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/usr/src/dump -XX:+ExitOnOutOfMemoryError
## Share
项目组从2017年初开始使用docker容器化部署到现在，出现了各种各样的问题。其中最主要的一个问题就是宿主机会莫名其妙的重启。其原因是容器占用了宿主机上太多的内存，在linux主机上，如果内核检测到没有足够的内存去执行重要的系统功能，就会引发OOME或者Out Of Memory Exception，然后开始通过杀死进程来释放内存。包括Docker以及其他一些重要的应用的进行，如果错误的进程被杀死，会导致整个系统宕机。所以在启动容器时一定要加上使用内存限制。

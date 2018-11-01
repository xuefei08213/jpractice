
## Alogrithom
### Problem:  [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/description/)
### Tags: Dynamic Programming
### Difficulty: Easy
### Description

Given an integer array nums,find the continius subarray(containing at least one number)which has the lagest sum and return the sum.

### Example
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
    
### Solution by Java
#### Solution 1

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
```

## Review
[Constructors Are Not Thread-Safe](http://bruceeckel.github.io/2017/01/13/constructors-are-not-thread-safe/)

When we imagine the construction processor,it can be easy to think it's thread-safe.After all,no one can see the object before it finishes initialization.
Unfortunately,Object construction is as vulnerable to shared-memory concurrency problems as anything else.
There are three approach to avoid this:
+ Use AtomicInteger to replace the int
+ Create your own using a synchronized block
+ make the constructor private and provide a static factory method to produce new Objects




## Technique

### 禁用HTTP不安全的方法
#### 问题来源

问题来源于测试人员对接口方法的一次安全测试。

#### 解决方案：

+ 给应用程序增加filter接口，过滤请求的HTTP方法，在HTTP方法不符合要求的情况下，直接返回405
+ 给应用程序的web.xml或者服务中间件（tomcat、weblogic）增加禁用不安全HTTP方法的配置文件

#### 代码展示
```xml
    <security-constraint>  
       <web-resource-collection>  
           <url-pattern>/*</url-pattern>  
           <http-method>PUT</http-method>  
           <http-method>DELETE</http-method>  
           <http-method>HEAD</http-method>  
           <http-method>OPTIONS</http-method>  
           <http-method>TRACE</http-method>  
       </web-resource-collection>  
       <auth-constraint>      
           <role-name>All Role</role-name>   
       </auth-constraint>  
       <user-data-constraint>   
           <transport-guarantee>NONE</transport-guarantee>   
       </user-data-constraint>
   </security-constraint>
```

## Share

  最近读了《富兰克林自传》，其中有一段是富兰克林为了养成自身的习惯，将自己想要养成的习惯通过表格的形式写在本子上，每天晚上会回顾白天的行为是否不符合预期的设想，如果不符合就打上❌，第二天会格外注意这些行为。
  
  我也效仿他把自己每天的起床、睡觉、运动、学习等习惯列出来，结果发现自身的自律是如此的差，需要改善的地方还很多。
  
  希望大家也可以去读下这本书，应该都会有一些自身的心得体验。


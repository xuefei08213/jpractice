
## Alogrithom
### Problem:  Search Insert Position
### Tags: 
### Difficulty: Easy
### Description:  
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

### Examples:
> Input: [1,3,5,6], 5  
> Output: 2  

> Input: [1,3,5,6], 2  
> Output: 1  

> Input: [1,3,5,6], 7  
> Output: 4  

> Input: [1,3,5,6], 0  
> Output: 0  
### Solution by Java
#### Solution 1
```java
   /**
     *定义hasOne变量用来标识是否找到一个第一个比target大的值，找到之后用map保存值跟索引的映射，并将hasOne设置为true
     * 遍历nums数组，找到第一个比target大值，并判断数组中是否有跟target相等的值，如果找到相等的值就直接返回
     * 在循环结束之后，判断map中是否有值，如果有值则取出对应的index，如果没有值，则说明target比数组中的所有的值都要大，它的索引应该是nums数组的长度
     */

    public int searchInsert(int[] nums, int target) {

        int result = 0;
        boolean hasOne = false;
        int firstKey = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > target && !hasOne) {
                firstKey = num;
                map.put(firstKey, i);
                hasOne = true;
            }

            if (num == target) {
                result = i;
                return result;
            }
        }
        
        if(map.isEmpty()) {
            result = nums.length;
        }else {
            result = map.get(firstKey);
        }
        return result;
    }
```
#### Solutuon 2
```java
    /**
     * 采用二分查找
     * 
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
```

## Review
[Dependency_injection](https://en.wikipedia.org/wiki/Dependency_injection)    
[IoC vs. DI](https://dzone.com/articles/ioc-vs-di)  

### 依赖注入（Dependency Injection）

在软件工程中，依赖注入是一个对象提供另一个对象所需依赖的技术。依赖注入将客户端依赖关系的创建跟客户端的行为分开，它允许程序设计松耦合，并遵循依赖倒置和单一原则。  
依赖是一个可以被使用的对象（也可以称之为服务）。注入是将依赖传递给使用它的对象（也可以称为客户端Client）。服务是客户端状态的一部分。  
依赖注入最基本的要求是将服务传递给客户端，不允许客户端自身去创建或者寻找他所需的服务。这意味着禁止使用通过new方法或者静态方法生成的服务。客户端应该从外界接收服务端。  

#### 目的
依赖注入的目的是将对象解耦到即使它依赖的对象需要为另一个，客户端也不需要（或者做出很少量）修改的程度。  

#### 优缺点

依赖注入的优点：
+ 依赖注入使得客户端可以灵活配置。只有客户端的行为是固定的。客户端可能会采取任何支持客户端期望的内在接口的行为
+ 依赖注入可用于将系统的配置细节外部化到配置文件中。允许在不重新编译的情况下重新配置系统。可以针对需要不同的组件不同的情况编写单独的配置。
+ 由于依赖注入不需要对代码行为做任何的修改，因此它可以做为重构应用于遗留代码。
+ 依赖注入允许客户端删除需要使用的具体实现的所有知识。这有助于将客户端与设计更改和缺陷的影响隔离开来。它促进了可重用性，可测试性和可维护性
+ 减少了应用程序代码的样板代码，因为所有用于初始化或设置依赖关系的工作都有提供程序组件处理
+ 依赖注入允许并行或独立开发。两个开发人员可以独立开发两个相互引用的类，他们之间通过接口联系
+ 依赖注入减少了类与其依赖之间的耦合
依赖注入的缺点：
+ 依赖注入创建客户端，需要通过构造代码提供配置细节。当明显的默认值可用时，这可能是繁重的。
+ 依赖注入可以使得代码难以跟踪（读取），因为它将行为从构造中分离出来。这意味着开发人员必须参考更多的文件来了解系统运行情况。
+ 依赖注入迫使复杂性转移到类之外，并进入类之间的联系，这可能不总是理想或容易管理的。
+ 依赖注入可以鼓励依赖注入框架

#### 依赖注入的方式  
+ 构造器注入
+ set方法注入
+ 接口注入

#### 示例  
```java
public class MyClass3 {
    public void doSomething(){}
}

//MyClass2 depends on MyClass3
public class MyClass2 {
    private MyClass3 myClass3;
    public MyClass2(MyClass3 myClass3){
        this.myClass3 = myClass3;
    }
    public void doSomething(){
        myClass3.doSomething();
    }
}

//MyClass1 depends on MyClass2
public class MyClass1 {
    private MyClass2 myClass2;
    public MyClass1(MyClass2 myClass2){
        this.myClass2 = myClass2;
    }
    public void doSomething(){
        myClass2.doSomething();
    }
}

public class Main {
    public static void main(String[] args) {
        //All dependencies need to be managed by the developer
        MyClass3 myClass3 = new MyClass3();
        MyClass2 myClass2 = new MyClass2(myClass3);
        MyClass1 myClass1 = new MyClass1(myClass2);
        myClass1.doSomething();
    }
}
```

### 控制反转（Inversion of Control）

#### 简介
IOC的非正式定义：帮你创建对象。
关于IOC的非常重要的想法：
+ 它被称为IOC，是因为对象的控制被反转。不是程序员，而是控制对象的其他人。
+ IOC是相对的，它只使用于应用程序的某些对象。
除了Spring之外，还有其他的例子，如Java Servlet和Akka Actors

#### 细节部分
IOC不仅仅是创建对象，一个Spring Context或者Servlet容器，不仅仅是创建对象，还要管理他们的生命周期。这包括创建对象，销毁对象，以及在其生命周期的不同阶段调用对象的某些方法。Spring Bean LifeStyle，Servlet LifeStyle，Akka Actor LifeStyle都实现类某种生命周期。  
另一件需考虑的事情是，尽管程序员放弃类对对象的控制，但是他们仍然需要定义IOC来创建所术对象的模版。比如在Spring中需要用@Component等注解或者XML配置文件，Servlet中所有实现了Servlet接口的类都会被Servlet容器管理。在akka应用中，Ioc容器称为ActorSystem，管理的对象是实现了特征类Actor的对象，并通过Props的配置对象创建。

### 控制反转与依赖注入的关系

在上面的示例中，类Main中main方法充当类注入器的左右，而这一切都是需要程序员去手动操作。如果我们现在需要给Class2增加一个Class4的依赖我们会怎么做？  
```java
// 修改MyClass2增加MyClass4的依赖
public class MyClass2 {
    private MyClass3 myClass3;
    private MyClass4 myClass4;
    public MyClass2(MyClass3 myClass3, MyClass4 myClass4){
        this.myClass3 = myClass3;
        this.myClass4 = myClass4;
    }
    public void doSomething(){
        myClass3.doSomething();
        myClass4.doSomething();
    }
}

// 修改main方法，增加MyClass4的创建并修改MyClass2的实现将MyClass4注入
public class Main {
    public static void main(String[] args) {
        MyClass4 myClass4 = new MyClass4();
        MyClass3 myClass3 = new MyClass3();
        MyClass2 myClass2 = new MyClass2(myClass3, myClass4);
        MyClass1 myClass1 = new MyClass1(myClass2);
        myClass1.doSomething();
    }
}
```

上面的情况，看起来不是特别复杂。但是在真正的开发项目中，这样的依赖关系肯定是成百上千的存在。如果要程序员手动去维护这些依赖肯定是不合理的，因此我们就需要控制反转跟依赖注入结合在一起使用。

## Technique

最近迁移项目的CI环境（采用docker搭建），主要迁移了其中的三个部分：gitlab,jenkins,nexus.  
github：采用gitlab-rake gitlab:backup:create命令备份好之后，将备份文件拷贝到新的机器上还原  
nexus：简单粗暴的将容器中挂载在宿主机上的文件压缩拷贝到新的机器上，解压，然后启动镜像  
jenkins： 主要是用了ThinBackup插件来进行备份还原  

## Share
这段

## Share
刚刚参加工作那会做华为项目，要求每个人每天要写日报，每周要写周报，也形成来有时间就翻看之前写的日报、周报进行总结，那感觉也蛮好的。可以是随着工作年限的增加以及项目组要求的变化，这个习惯慢慢的也就丢了。可是，最近发现自己老是回忆不起最近一段时间的工作，感觉每天的时间都虚度了。所以又把这个习惯重新拾起，每天花费10分钟来回顾今天的工作，包括遇到的问题，涉及的技术以及需要加强学习的知识，这样也可以对今后的学习有个计划。  
希望大家也能够养成这样的习惯。

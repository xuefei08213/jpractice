# 流的定义：
从支持数据处理操作的源生成的元素序列  
### 元素序列：
就像集合一样，流也提供了一个接口，可以访问特定元素类型的一组有序值。因为集合是数据结构，所以它的主要目的是以特定的时间/空间复杂度存储和访问元素。但流的目的在于表达计算，比如filter，sorted和map。集合讲的是数据，流讲的是计算。  
### 源：
流会使用一个提供数据的源，如集合，数组或输入/输出资源  
### 数据处理操作：
流的数据处理功能支持类似于数据库的操作，以及函数式编程语言的常用操作，如filter，map，reduce，find，match，sort等。流操作可以顺序执行，也可以并行执行。

## 集合跟流的区别
+ 粗略的说，集合与流之间的差异就在于什么时候进行计算。集合是内存中的一个数据结构，它包含数据结构中目前所有的值--集合中每一个元素都得算出来才能添加到集合中。（你可以往集合中加东西或删东西，但是不管什么时候，集合中的每个元素都是放在内存中的，元素得先算出来才能成为集合的一部分）    
+ 相比之下，流则是在概念上固定的数据结构，其元素则是按需计算的。    
+ 从另一个角度讲，流像是一个延迟创建的集合：只有在消费者要求的时候才能计算值。    

集合和流的另一个关键区别在于它们遍历数据的方式
使用Collection接口需要用户去做迭代（比如for-each），这称为外部迭代。
Streams库使用内部迭代。内部迭代可以自动选择一种适合你硬件的数据表示和并行实现。


流操作
java.util.stream.Stream中的Stream接口定义了许多操作，它们可以分为两大类：
中间操作：诸如filter或sorted等中间操作会返回另一个流。这让多个操作可以连接起来形成一个查询。重要的是，除非流水线上触发一个终端操作，否则中间操作不会执行任何处理。这是因为中间操作一般都可以合并起来，在终端操作时一次性全部处理。

终端操作：终端操作会从流的流水线生成结果。其结果是任何不是流的值。

map：映射
接受一个函数作为参数，这个函数会被应用在每个元素上，并将其映射成一个新的元素

flatmap方法让你把一个流中的每个值换成另一个流，然后把所有的流连接起来成为一个流

查找和匹配：看看数据集中的某些元素是否匹配一个给定的属性
allMatch：检查谓词是否匹配所有元素
anyMatch:检查谓词是否至少匹配一个元素，流中是否有一个元素能匹配给定的谓词
noneMatch：确保流中没有任何元素与给定的谓词匹配
findFirst：查找第一个元素
findAny:返回当前流中的任意元素

何时使用findAny和findFirst
找到第一个元素在并行上限制更多。如果不关心返回的元素是哪个，请使用findAny，因为它在使用并行流时限制更少

短路操作
对于流而言，某些操作（例如allMatch,anyMatch,noneMatch,findFirst和findAny）不用处理整个流就能得到结果，只要找到一个元素，就可以有结果
limit也是短路操作：它只需要创建一个指定大小的流，而用不着处理流中所有的元素

归约
reduce

原始类型流特化
映射到数值流 mapToInt（IntStream） mapToDouble（DoubleStream） mapToLong(longStream)可以调用sum方法

转换为对象流：调用boxed()方法

OptionalInt

数值范围：
IntStream、longStream有range和rangeClosed方法来获取数值范围。接收两个参数，第一个为起始值，第二个为结束值。range不包含结束值，rangeClosed包含结束值

构建流
由值创建流：Stream.of  
由数组创建流：Arrays.stream  
由文件生成流：  
由函数生成流：  
  Stream.iterate(0,n ->  n+2)  
  Stream.generate(Math::random)


收集器
对流调用collect方法将流中的元素触发一个归约操作（由Collector来参数化）

Collectors.counting
Collectors.maxBy
预定义收集器（可以从Collectors类提供的工厂方法，（如groupingBy）创建的收集器）
将元素归约和汇总为一个值
汇总包括求和以及求平均值
Collectors.summingInt
Collectors.averagingInt
Collectors.summingLong
Collectors.summingDouble

如果想一次性完成给流中的元素计数，找到这些元素属性的最大值和最小值以及计算其总和和平均值，可以调用summarizingInt（summarizingLong,summarizingDouble）

joining工厂方法返回的收集器会把对象流中的每一个对象应用toString方法得到的字符串连接成一个字符串
joining在内部使用流StringBuilder来把生成的字符串逐个追加起来

上面讨论的收集器，都是一个可以用reducing工厂方法定义的归约过程的特殊情况而已
Collectors.reducing工厂方法是所有这些特殊情况的一般化
Collectors.reducing有三个参数：初始值，转换函数啊以及累积函数

元素分组  
groupingBy  
元素分区  
partitioningBy


Optional
创建OPtional对象
声明一个空的Optional：Optional.empty()
依据一个非空值创建Optional：  
Optional.of(car),这里如果car为null，这段代码会立即抛出NullPointException，而不是等你试图访问car的属性时才抛出异常
可接受null的Optional  
Optional.ofNullable(car);

使用map从Optional对象中提取和转换值
使用flatMap链接Optional对象

返回Optional可能是两种情况：如果调用链上的任何一个方法返回一个空的Optional，那么结果就是空的。否则就是你期望的值。

在域模型中使用Optional，以及为什么它们无法序列化  
Optional的设计初衷仅仅是要支持能返回Optional对象的方法，并没有考虑将其作为类的字段使用，所以它并为实现Serializable接口。
由于这个原因，如果你的应用使用了某些需要序列化的库或者框架，在域模型中使用Optional，有可能引发程序异常。

Optional提供了多种提取Optional实例中的变量值
get()
orElse(T other)
orElseGet(Supplier<? extends T> other)
orElseThrow(Supplier<? extends X> exceptionSupplier)
ifPresent(Consumer<? super T>)

Future接口  
Future在Java5中被引入，设计初衷是对将来某个时刻会发生的结果进行建模。它建模了一种异步计算，返回一个执行计算结果的引用，当运算结束后这个引用被返回给调用方。在Future中触发那些耗时的操作把调用线程解放出来，让它能够执行更加有意义的事情，不需要等待耗时的操作完成。  
要使用Future，通常只需要将耗时的操作封装在一个Callable对象中，再将它提交给ExecutorService，就可以了。  

```java
ExecutorService executor = Executors.newCacheThreadPool();
Future<Double> future = executor.submit(new Callable<Double>(){
    public Double call(){
        return doSomeLongCompution();
    }
});
doSomethingElse();
try{
    Double result = future.get(1,TimeUnit.SECONDS);
} catch (ExecutionException ee){
    // 计算抛出一个异常
} catch (InterruptedException ie) {
    // 当前线程在等待过程中被中断
}  catch (TimeoutException te) {
    // 在Future对象完成之前已经过期
}
````

CompletableFuture  
supplyAsync：接收一个生产者作为参数，返回一个CompletableFuture对象，该对象完成异步执行之后会读取调用生产者方法的返回值。生产者方法会交由ForkJoinPool池中的某个线程（Executor）运行，但是也可以使用supplyAsync方法的重载版本，传入第二个参数指定不同的执行线程执行生产者方法。

CompletableFuture和并行流的异同：它们内部采用的是同样的通用线程池，默认都使用固定数目的线程，具体线程数取决于Runtime.getRuntime().availableProcessors()的返回值。然而，CompletableFuture具有一定的优势，因为它允许对执行器（Executor）进行配置，尤其是线程的大小，让它更适合应用需求的方式进行配置，满足程序需求，这是并行流API无法提供的。

thenCompose方法允许对两个异步操作进行流水线，第一个操作完成时，将其结果作为参数传递给第二个操作
thenCombine 将两个完全不相干CompletableFuture对象的结果整合起来，而且你也不希望等到第一个任务完全结 束才开始第二项任务。
thenAccept 只要有结果，就可以立即执行，而不是等所有结果都返回


LocalDate  
LocalDate.of  
LocalDate.now()  
LocalTime  
LocalTime.of

LocalDateTime 同时表示日期时间，但是不带有时区信息
通过各自的atTime或者atDate方法，向LocalDate传递一个时间对象，或向LocalTime传递一个日期对象的方式，可以创建一个LocalDateTime对象  
你也可以使用toLocalDate或者toLocalTime方法，从LocalDateTime中提取LocalDate或LocalTime组件

机器的日期和时间格式  
从计算机的角度来看，建模时间最自然的格式是表示一个持续时间段上某个点的单一大整型数。  
java.time.Instant类对时间建模的方式，基本上它是以Unix元年时间（传统的设定为UTC时区1970年1月1日午夜时间）开始经历的描述进行计算  
你可以通过向静态工厂方法ofEpochSecond传递一个代表秒数的值创建一个该类的实例。
Instant设计的初衷是为了便于机器使用，它包含的是由秒以及纳秒所构成的数字。所以，它无法处理那些我们非常容易理解的时间单位

Duration

Period

withAttribute创建时间的修改版本

使用TemporalAdjuster进行更加复杂的操作以及自定义








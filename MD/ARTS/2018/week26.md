## Alogrithom
### Problem:  [two sum](https://leetcode.com/problems/two-sum/description/)
### Tags: Array
### Difficulty: Easy
### Description

Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

### Example

    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
    
### Solution by Java
#### Solution 1

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
```

运行时长：54ms    
时间复杂度为O(n^2)    
此解决方案，自己写的，很粗暴。因为针对每个元素都要对剩余的元素来遍历并判别是不是符合条件的值。



#### Solutuon 2
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
```

运行时长：10ms    
时间复杂度O(n)    
此解决方案，是先将数组元素的值跟对应的index保存在map中，通过HashMap将查找的时间复杂度从O(n)降低到O(1)


#### Solutuon 3
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { map.get(complement), i };
        } else {
            map.put(nums[i], i);
        }
    }
   throw new IllegalArgumentException("No two sum solution");
   }
}
```

运行时长：11ms    
时间复杂度O(n)    
跟Solutuon 2相比较，此解决方案对数组只遍历一次

这道题目，预先限定来解决方案只有一种。如果得到目标数值的组合有多种，可能就需要用集合来保存结果，然后在此基础上在对值是否相同做处理。

## Review
[Top 8 Signs of Bad Unit Testcases](https://howtodoinjava.com/best-practices/8-signs-of-bad-unit-test-cases/)
+  Test passes but not testing the actual feature

    写了很多的代码，但是却没有做任何事情。比如，发送请求到服务端，无论服务端返回什么测试用例都是通过的。

+ Testing irrelevant things

    检查多个不相关的事情，以便通过一些测试用例，但是不一定做了正确的事情。最好的方式是遵循单一原则，即单个测试用例只测试一个事情。

+ Testing multiple things in assertions

    一个断言测试太多的事情，违背了单一原则。
    对于一个实体类，如果是正常情况的测试，可以在一个断言中测试所有的字段属性。如果是异常情况，就可以单独对字段进行测试。

+ Test accessing the testee using reflexion

    通过反射修改被测试的代码，在开发人员重构代码的时候会导致测试用例失败。

+ Tests swalloing exceptions

    默默地生吞异常，更糟糕的是不发出失败的警报。异常是程序抛出的意味着发生了不好的事情的信号，是必须要调查的。不应该允许测试用例忽略它。

+ Test which depends on excessive setup

    需要许多的前置条件才能进行真正的用例测试，遇到这样的情况，可以使用Mock。

+ Test compatible to only developer machine

    测试用例只能在开发者的机器上正常运行。

+ Test filling log files with load of texts

    测试不适用于调试应用程序，所以不要把调试日志种类陈述。通过简单的单个日志语句就足够了。

## Technique

### WebFlux非阻塞业务处理
#### 问题来源

此问题来源于工作中的一个场景。前端发送一个请求，后台业务处理逻辑耗时较长。
解决方案：
后台程序每次接收到前端请求之后，将消息处理后放入kafka中，构造Webflux的MonoProcessor并通过Webflux构造响应返回
在内存中缓存消息跟MonoProcessor的对应关系（RequestRouterActor）
处理程序从kafka中消费请求消息，处理完之后，将处理结果放入kafka消息队列中
新启动一个线程监听kafka响应消息，查询对应的MonoProcessor，触发其onNext方法

#### 所用技术

WebFlux,Actor,kafka

#### 代码展示

```java
public class RequestHandler {

	public Mono<ServerResponse> handlerGet(ServerRequest request) {

		// 生成代表请求的唯一标识
		Random random = new Random();
		long transactionId = random.nextLong();

		// 获取ServerRequest的信息,将transactionId以及业务所需的信息一起发送到kafka消息队列中
		pushRequest(transactionId, request);

		// ResponseMessage为自定义的响应对象
		MonoProcessor<ResponseMessage> monoProcessor = MonoProcessor.create();

		// 通过Actor tell 逻辑处理Actor
		dispatcher.push(new TransPair(transactionId, monoProcessor));
    
    // 构造响应并返回
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(monoProcessor, ResponseMessage.class);
	}

	private void pushRequest(long transactionId, ServerRequest request) {

		// 获取ServerRequest的信息,将transactionId以及业务所需的信息一起发送到kafka消息队列中
		// 可以使用Map或者对象
	}

	public static class TransPair {

		private long transId;
		private MonoProcessor<ResponseMessage> monoProcessor;

		public long getTransId() {
			return transId;
		}

		public void setTransId(long transId) {
			this.transId = transId;
		}

		public MonoProcessor<ResponseMessage> getMonoProcessor() {
			return monoProcessor;
		}

		public void setMonoProcessor(MonoProcessor<ResponseMessage> monoProcessor) {
			this.monoProcessor = monoProcessor;
		}

		public TransPair(long transId, MonoProcessor<ResponseMessage> monoProcessor) {
			this.transId = transId;
			this.monoProcessor = monoProcessor;
		}
	}
}
```

```java
public class RequestRouterActor extends AbstractActorWithTimers {

    public RequestRouterActor() {
        // 定期触发清理
        this.getTimers().startPeriodicTimer("flush", new Clean(), Duration.create(15, TimeUnit.SECONDS));
    }
    
    // 用于保存transcationId跟MonoProcessor的对应
    private Map<Long, MonoRepository> map = new HashMap<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see akka.actor.AbstractActor#createReceive()
	 */
	@Override
	public Receive createReceive() {
		return this.receiveBuilder().match(TransPair.class, x -> {
      // 缓存请求transactionId和MonoProcessor
			map.put(x.getTransId(), new MonoRepository(System.currentTimeMillis(), x.getMonoProcessor()));
		}).match(Clean.class, x -> {
			doClean();
		}).match(ResponseMessage.class, r -> {
			if (map.containsKey(r.getTransactionId())) {
          // 从缓存中获取对应MonoProcessor，调用onNext方法，将响应消息放入通道
          map.remove(r.getTransactionId()).getProcessor().onNext(r);
			}
		}).build();
	}
	
  // 定义超时时间
	private static long waitTime = 60 * 1000;
	
	public static ResponseMessage TIMEOUT = new ResponseMessage(); 
	static {
		TIMEOUT.setStateCode(ResponseMessage.NG);
		TIMEOUT.setBody("请求超时");
	}
	
	/**
	 * 
	 */
	private void doClean() {
		long currentTime = System.currentTimeMillis();
		List<Long> timeOutKeys = new ArrayList<>();
		map.entrySet().stream().filter(e-> currentTime - e.getValue().getCreateTime() >= waitTime).forEach(e->{
			e.getValue().getProcessor().onNext(TIMEOUT);
			timeOutKeys.add(e.getKey());
		});
		timeOutKeys.stream().forEach(map::remove);
	}


	private static class Clean {
		
	}
  
  
	public static class MonoRepository {
		
		private long createTime;
		
		private MonoProcessor<ResponseMessage> processor;

		/**
		 * @param createTime
		 * @param processor
		 */
		public MonoRepository(long createTime, MonoProcessor<ResponseMessage> processor) {
			this.createTime = createTime;
			this.processor = processor;
		}

		/**
		 * @return the createTime
		 */
		public long getCreateTime() {
			return createTime;
		}

		/**
		 * @return the processor
		 */
		public MonoProcessor<ResponseMessage> getProcessor() {
			return processor;
		}
		
	}

}
```


## Share

其实我工作也有五六年了，做了四年外包（三年后端，一年前端），目前是写公司微服务平台的底层架构。在做外包的那段时间，学的最多的就是各种框架怎么用。除了Spring，其他的都没有深入学习其中的原理。读了《左耳听风》专栏，感慨颇深，这里只想跟群里的朋友说几句自己的观点：
  + 找工作能不选择外包择不选择外包。
  + 30岁之前跳槽，薪资都不要放在第一位，发展最重要，职业规划也很重要。
  + 不管用什么语言开发，基础都是很重要的，因为它决定了你能达到的高度。
  + 一定不要给自己机会在几年之后对自己说当初该怎么样该多好。
  + 希望大家抓住耗哥给我们的这个平台。




## Alogrithom
### Problem:  [jewels-and-stones](https://leetcode.com/problems/jewels-and-stones/)
### Description
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

### Example

#### Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3

#### Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.


#### Solution
````java
class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        int[] jewels = new int[50];
        for(int i = 0;i<S.length();i++){
            String str = S.
            int index = hashFunc(J, str);
            if (index >= 0) {
                jewels[index]++;
            }
        }

        for (int j = 0; j < jewels.length; j++) {
            count += jewels[j];
        }

        return count;
    }
    
    private int hashFunc(String J, String s){
        return J.indexOf(s);
    }
}
````


## Review
[10 Common Software Architectural Patterns in a nutshell](https://towardsdatascience.com/10-common-software-architectural-patterns-in-a-nutshell-a0b47a1e9013)

本文介绍了10种常见的架构模式以及其用法以及优缺点

+ Layered pattern  
通常情况下将系统分成四层Presentation layer (also known as UI layer)、Application layer (also known as service layer)、Business logic layer (also known as domain layer)、Data access layer (also known as persistence layer).

+ Client-server pattern  
这个模式通常由客户端以及服务端两个部分组成，它们是一对多的关系。一个服务器组件将为多个客户端组件提供服务。客户端从服务器请求服务，服务器向客户端提供相关服务。此外，服务器还需要监听客户端请求。  
这个模式通常用在邮件系统，文件共享系统以及银行系统。

+ Master-slave pattern  
这个模式由master和slaves两部分组成。master节点给slave节点分配任务，并根据slave节点的结果计算最终结果。  
这个模式通常用于数据库的复制。

+ Pipe-filter pattern  
该模式可以用于构建生成和处理数据流的系统。每个处理步骤都包含在过滤器组件中，数据通过管道传递。这些管道可用于缓冲或用于同步。  
这个模式可以用于编译器（Compilers）。连续过滤器执行词法分析，解析，语义分析和代码生成。

+ Broker pattern  
此模式用于构建具有分离组件的分布式系统。这些组件通过远程服务调用相互交互，代理组件负责协调组件之间的通信。  
服务器将其功能（服务和特征）发布到代理。客户端从代理请求服务，然后代理将客户端从注册表重定向到合适的服务。  
该模式在消息代理软件中使用比较多，Apache ActiveMQ, Apache Kafka, RabbitMQ and JBoss Messaging.

+ Peer-to-peer pattern  
在这个模式中，每个组件既可以是客户端也可以是服务端，而且可以动态的切换角色。  
在文件共享网络（ Gnutella and G2）以及多媒体协议 P2PTV and PDTP中使用的比较常见

+ Event-bus pattern  
这个模式由四个部分组成，事件源、事件监听、通道（channel）以及事件总线。事件源将事件发布到事件总线上的特定通道，事件监听订阅特定的通道。当消息发布到一个通道，事件监听者就会收到通知消息。

+ Model-view-controller pattern  
这个就是大家熟知的MVC模式

+ Blackboard pattern  

+ Interpreter pattern  
此模式用于设计解释用专用语言编写的程序的组件。这些主要是指以某种特定的语言写的语句或者表达式。基本思想是为语言的每一个符号设定一个类。  
主要用在数据库查询语言（SQL），用于描述通信协议的语言。

## Technique

项目中的有一个比较大的功能是数据的集成，数据从数据源开始经过数据处理然后进入目标库。但是部署现场的过程遇到了各种各样的问题，定位问题非常困难。于是，就采用了sleuth+logstash+elastic的架构将数据流的走向显示出来，以便定位问题。  
在这里，我想给大家分享下，对于web程序sleuth是如何把相关信息展示在日志中的。
首先sleuth里面用的是brave，brave提供了brave-instrumentation-servlet模块，而每次的servlet请求都会被TracingFilter拦截，检查scope，span。最终通过Slf4jCurrentTraceContext
的newScope方法来创建span。在这个方法里面会调用MDC来保存相关内容，这样输出日志的时候就可以将相关的内容输出。  

```java
@Override public Scope newScope(@Nullable TraceContext currentSpan) {
		final String previousTraceId = MDC.get("traceId");
		final String previousParentId = MDC.get("parentId");
		final String previousSpanId = MDC.get("spanId");
		final String spanExportable = MDC.get("spanExportable");
		final String legacyPreviousTraceId = MDC.get(LEGACY_TRACE_ID_NAME);
		final String legacyPreviousParentId = MDC.get(LEGACY_PARENT_ID_NAME);
		final String legacyPreviousSpanId = MDC.get(LEGACY_SPAN_ID_NAME);
		final String legacySpanExportable = MDC.get(LEGACY_EXPORTABLE_NAME);

		if (currentSpan != null) {
			String traceIdString = currentSpan.traceIdString();
			MDC.put("traceId", traceIdString);
			MDC.put(LEGACY_TRACE_ID_NAME, traceIdString);
			String parentId = currentSpan.parentId() != null ?
					HexCodec.toLowerHex(currentSpan.parentId()) :
					null;
			replace("parentId", parentId);
			replace(LEGACY_PARENT_ID_NAME, parentId);
			String spanId = HexCodec.toLowerHex(currentSpan.spanId());
			MDC.put("spanId", spanId);
			MDC.put(LEGACY_SPAN_ID_NAME, spanId);
			String sampled = String.valueOf(currentSpan.sampled());
			MDC.put("spanExportable", sampled);
			MDC.put(LEGACY_EXPORTABLE_NAME, sampled);
			log("Starting scope for span: {}", currentSpan);
			if (currentSpan.parentId() != null) {
				if (log.isTraceEnabled()) {
					log.trace("With parent: {}", currentSpan.parentId());
				}
			}
		}
		else {
			MDC.remove("traceId");
			MDC.remove("parentId");
			MDC.remove("spanId");
			MDC.remove("spanExportable");
			MDC.remove(LEGACY_TRACE_ID_NAME);
			MDC.remove(LEGACY_PARENT_ID_NAME);
			MDC.remove(LEGACY_SPAN_ID_NAME);
			MDC.remove(LEGACY_EXPORTABLE_NAME);
		}

		Scope scope = this.delegate.newScope(currentSpan);

		class ThreadContextCurrentTraceContextScope implements Scope {
			@Override public void close() {
				log("Closing scope for span: {}", currentSpan);
				scope.close();
				replace("traceId", previousTraceId);
				replace("parentId", previousParentId);
				replace("spanId", previousSpanId);
				replace("spanExportable", spanExportable);
				replace(LEGACY_TRACE_ID_NAME, legacyPreviousTraceId);
				replace(LEGACY_PARENT_ID_NAME, legacyPreviousParentId);
				replace(LEGACY_SPAN_ID_NAME, legacyPreviousSpanId);
				replace(LEGACY_EXPORTABLE_NAME, legacySpanExportable);
			}
		}
		return new ThreadContextCurrentTraceContextScope();
	}
```
## Share
分享一个不知道具体调用过程的时候，就好像filter这些，直接看代码有可能看不到（一般都出现在config文件里面）。在这样的情况，可以通过在确定的代码里面打断点，然后通过eclipse的debug的调用堆栈来确定调用过程，然后在诸逐个的分析源码。
    

/**
 * 
 */
package org.jpractice.jvm.classloader.passiveref.demo73;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-06-20 07:16:15
 * @Description: 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
 * @version V1.0
 */
public class ConstClass {

	static {
		System.out.println("ConstClass init!");
	}

	public static final String HELLOWORLD = "hello world";

}

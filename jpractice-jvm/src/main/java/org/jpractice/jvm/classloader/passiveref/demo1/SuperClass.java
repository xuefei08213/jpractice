/**
 * 
 */
package org.jpractice.jvm.classloader.passiveref.demo1;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-06-19 13:54:50
 * @Description: 被动使用类字段演示一： 通过子类引用父类的静态字段，不会导致子类初始化
 * @version V1.0
 */
public class SuperClass {

	static {
		System.out.println("SuperClass init!");

	}

	public static int value = 123;
}

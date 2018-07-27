/**
 * 
 */
package org.jpractice.jvm.classloader.passiveref.demo1;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-06-19 13:57:36
 * @Description: TODO
 * @version V1.0
 */
public class SubClass extends SuperClass {

	static {
		System.out.println("SubClass init!");
	}
}

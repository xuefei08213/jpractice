/**
 * 
 */
package org.jpractice.designpatterns.di.demo1.baddesign;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-06-30 10:20:55
 * @Description: TODO
 * @version V1.0
 */
public class Car {

	private Bottom bottom;

	public Car() {
		// TODO Auto-generated constructor stub
		this.bottom = new Bottom();
	}

	public void run() {

	}
}

/**
 * 
 */
package org.jpractice.designpatterns.di.demo1.baddesign;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-06-30 10:17:25
 * @Description: 汽车底盘
 * @version V1.0
 */
public class Bottom {

	private Tire tire;

	Bottom() {
		this.tire = new Tire();
	}
}

/**
 * 
 */
package org.jpractice.designpatterns.di.demo1.baddesign;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-06-30 10:20:01
 * @Description: 车身
 * @version V1.0
 */
public class Framework {

	private Bottom bottom;

	Framework() {
		this.bottom = new Bottom();
	}
}

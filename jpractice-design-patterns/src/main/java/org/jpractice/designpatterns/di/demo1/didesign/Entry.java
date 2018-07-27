/**
 * 
 */
package org.jpractice.designpatterns.di.demo1.didesign;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-06-30 11:38:56
 * @Description: TODO
 * @version V1.0
 */
public class Entry {

	public static void main(String[] args) {
		/**
		 * 这里如果需要修改下轮胎的尺寸，只需要修改{@link Tire} 以及这里的Tire tire = new Tire();即可 这部分代码
		 * 可以通过IOC容器
		 */
		Tire tire = new Tire();
		Bottom bottom = new Bottom(tire);
		Framework framework = new Framework(bottom);
		Car car = new Car(framework);
		car.run();
	}
}

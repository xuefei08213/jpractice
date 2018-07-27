/**
 * 
 */
package org.jpractice.jvm.classloader.passiveref;

import org.jpractice.jvm.classloader.passiveref.demo1.SubClass;
import org.jpractice.jvm.classloader.passiveref.demo1.SuperClass;
import org.jpractice.jvm.classloader.passiveref.demo73.ConstClass;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-06-19 13:59:45
 * @Description: 非主动使用类字段演示
 * @version V1.0
 */
public class NotInitialization {

	public static void main(String[] args) {

		/**
		 * 对于静态字段，只有直接定义这个字段的类才会被初始化。 因此通过其子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化。
		 * 至于是否要触发子类的加载和验证，在虚拟机中并未明确规定，这点取决于虚拟机的具体实现，对于Sun
		 * HotSpot虚拟机来说，可通过-XX:+TraceClassLoading参数观察到此操作会导致子类的加载。
		 */
		System.out.println(SubClass.value);

		/**
		 * 下面的代码运行之后并没有输出"SuperClass init!"，说明没有触发{@link SuperClass}的初始化阶段。
		 * 但是这段代码里面触发了另一个名为"[Ljvm.classloader.passiveref.demo1.SuperClass"的类的初始化阶段，
		 * 对于用户代码来说，这并不是一个合法的类名称，它是由虚拟机自动生成的、直接继承于java.lang.Object的子类，
		 * 创建动作由字节指令newarray触发。
		 * 这个类代表了元素类型为jvm.classloader.passiveref.demo1.SuperClass的一维数组，
		 * 数组中应有的属性和方法都实现在这个类里面
		 */
		SuperClass[] superClasses = new SuperClass[10];

		/**
		 * 下面的代码运行之后，不会输出"ConstantClass
		 * init!",这是因为虽然Java源码中引用了{@link ConstClass}类中的常量HELLOWORLD,但其实在编译阶段通过传播优化，
		 * 已经将此常量的值"hello world"存储到类NotInitialization的常量池中，
		 * 以后NotInitialization对常量ConstClass.HELLOWORLD的引用实际上都转换为NotInitialization对自身常量池的引用
		 * 也就是说，实际上NotInitialization的Class文件中并没有ConstClass类的符号引用入口，这两个类在编译成Class之后就
		 * 不存在任何联系了
		 */
		System.out.println(ConstClass.HELLOWORLD);
	}
}

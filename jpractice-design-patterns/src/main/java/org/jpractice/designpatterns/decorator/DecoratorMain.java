/**
 * 
 */
package org.jpractice.designpatterns.decorator;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-09-18 07:21:54
 * @Description: TODO
 * @version V1.0
 */
public class DecoratorMain {

    public static void main(String[] args) {
        Snack chickenLegRice = new ChickenLegRice();
        chickenLegRice = new GreensDecortor(chickenLegRice);
        System.out.println(chickenLegRice.getCost());
    }
}

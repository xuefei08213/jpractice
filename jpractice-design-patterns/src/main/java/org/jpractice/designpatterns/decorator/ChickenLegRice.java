/**
 * 
 */
package org.jpractice.designpatterns.decorator;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-09-18 07:10:36
 * @Description: TODO
 * @version V1.0
 */
public class ChickenLegRice extends Snack {

    @Override
    public void getDescription() {
        System.out.println("鸡腿饭");
    }

    @Override
    public int getCost() {
        return 10;
    }

}

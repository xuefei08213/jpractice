/**
 * 
 */
package org.jpractice.designpatterns.decorator;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-09-18 07:11:58
 * @Description: TODO
 * @version V1.0
 */
public abstract class Decorator extends Snack {

    @Override
    public abstract void getDescription();

    @Override
    public abstract int getCost();

}

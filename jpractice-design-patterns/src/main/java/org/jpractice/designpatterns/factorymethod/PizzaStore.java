/**
 * 
 */
package org.jpractice.designpatterns.factorymethod;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-19 06:19:38
 * @Description: TODO
 * @version V1.0
 */
public abstract class PizzaStore {

    protected abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}

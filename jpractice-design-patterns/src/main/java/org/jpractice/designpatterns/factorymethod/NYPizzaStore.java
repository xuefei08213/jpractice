/**
 * 
 */
package org.jpractice.designpatterns.factorymethod;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-19 06:22:53
 * @Description: TODO
 * @version V1.0
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {

        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        }
        return null;
    }

}

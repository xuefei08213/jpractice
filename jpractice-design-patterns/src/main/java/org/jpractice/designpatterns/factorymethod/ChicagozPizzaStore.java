/**
 * 
 */
package org.jpractice.designpatterns.factorymethod;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-19 06:30:18
 * @Description: TODO
 * @version V1.0
 */
public class ChicagozPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        }
        return null;
    }

}

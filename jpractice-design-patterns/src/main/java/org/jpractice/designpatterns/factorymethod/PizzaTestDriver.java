/**
 * 
 */
package org.jpractice.designpatterns.factorymethod;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-19 06:31:29
 * @Description: TODO
 * @version V1.0
 */
public class PizzaTestDriver {

    public static void main(String[] args) {

        PizzaStore nyStore = new NYPizzaStore();

        PizzaStore chicagoStore = new ChicagozPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a" + pizza.name);

        pizza = chicagoStore.orderPizza("cheese");

        System.out.println("Joel ordered a" + pizza.name);

    }

}

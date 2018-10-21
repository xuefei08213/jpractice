/**
 * 
 */
package org.jpractice.designpatterns.factorymethod;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-19 06:12:53
 * @Description: TODO
 * @version V1.0
 */
public class NYStyleCheesePizza extends Pizza {

    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }

}

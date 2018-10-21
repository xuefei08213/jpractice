/**
 * 
 */
package org.jpractice.designpatterns.factorymethod;

import java.util.ArrayList;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-19 06:05:51
 * @Description: TODO
 * @version V1.0
 */
public abstract class Pizza {

    String name;

    String dough;

    String sauce;

    ArrayList<String> toppings = new ArrayList<>();

    public void prepare() {
        System.out.println("Preparing" + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Add toppings:");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println(" " + toppings.get(i));
        }
    }

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in offical PizzaStore box");
    }

    public String getName() {
        return name;
    }

}

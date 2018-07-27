/**
 * 
 */
package org.jpractice.java8.stream;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-03 20:34:41
 * @Description: TODO
 * @version V1.0
 */
public class Dish {

    private final String name;

    private final boolean vagetarian;

    private final int calories;

    private final Type type;

    public Dish(String name, boolean vagetarian, int calories, Type type) {
        this.name = name;
        this.vagetarian = vagetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVagetarian() {
        return vagetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        MEAT, FISH, OTHER
    }

}

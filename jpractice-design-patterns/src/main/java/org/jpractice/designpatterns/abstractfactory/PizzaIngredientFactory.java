/**
 * 
 */
package org.jpractice.designpatterns.abstractfactory;

import org.jpractice.designpatterns.abstractfactory.ingredient.Cheese;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-19 07:22:35
 * @Description: TODO
 * @version V1.0
 */
public interface PizzaIngredientFactory {

    public Cheese createCheese();

}

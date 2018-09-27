/**
 * 
 */
package org.jpractice.designpatterns.decorator;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-09-18 07:13:53
 * @Description: TODO
 * @version V1.0
 */
public class GreensDecortor extends Decorator {

    private Snack snack;

    public GreensDecortor(Snack snack) {
        super();
        this.snack = snack;
    }

    @Override
    public void getDescription() {
        System.out.println("增加青菜");
    }

    @Override
    public int getCost() {
        return 1 + snack.getCost();
    }

}

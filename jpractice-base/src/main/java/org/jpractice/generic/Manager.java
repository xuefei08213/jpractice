/**
 * 
 */
package org.jpractice.generic;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-15 08:14:14
 * @Description: TODO
 * @version V1.0
 */
public class Manager extends Employee {

    private double bounds;

    public Manager(String name, double bounds) {
        super(name);
        this.bounds = bounds;
    }

    public double getBounds() {
        return bounds;
    }

    public void setBounds(double bounds) {
        this.bounds = bounds;
    }

}

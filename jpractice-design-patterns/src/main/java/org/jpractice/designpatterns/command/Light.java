/**
 * 
 */
package org.jpractice.designpatterns.command;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-23 22:42:56
 * @Description: The Receiver class
 * @version V1.0
 */
public class Light {
    public void turnOn() {
        System.out.println("The light is on");
    }

    public void turnOff() {
        System.out.println("The light is off");
    }
}

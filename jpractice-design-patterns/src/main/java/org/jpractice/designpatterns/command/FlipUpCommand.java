/**
 * 
 */
package org.jpractice.designpatterns.command;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-23 22:43:29
 * @Description: TODO
 * @version V1.0
 */
public class FlipUpCommand implements Command {
    private Light theLight;

    public FlipUpCommand(final Light light) {
        this.theLight = light;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        theLight.turnOn();
    }

}

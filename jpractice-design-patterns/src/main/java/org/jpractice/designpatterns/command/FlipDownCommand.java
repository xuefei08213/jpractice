/**
 * 
 */
package org.jpractice.designpatterns.command;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-23 22:44:25
 * @Description: The Command for turning off the light - ConcreteCommand #2
 * @version V1.0
 */
public class FlipDownCommand implements Command {
    private Light theLight;

    public FlipDownCommand(final Light light) {
        this.theLight = light;
    }

    @Override // Command
    public void execute() {
        theLight.turnOff();
    }
}

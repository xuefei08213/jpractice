/**
 * 
 */
package org.jpractice.designpatterns.command;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-23 22:44:54
 * @Description: The test class or client
 * @version V1.0
 */
public class PressSwitch {

    public static void main(final String[] arguments) {
     // Check number of arguments
        if (arguments.length != 1) {
           System.err.println("Argument \"ON\" or \"OFF\" is required!");
           System.exit(-1);
        }

        final Light lamp = new Light();
        
        final Command switchUp = new FlipUpCommand(lamp);
        final Command switchDown = new FlipDownCommand(lamp);

        final Switch mySwitch = new Switch();

        switch(arguments[0]) {
           case "ON":
              mySwitch.storeAndExecute(switchUp);
              break;
           case "OFF":
              mySwitch.storeAndExecute(switchDown);
              break;
           default:
              System.err.println("Argument \"ON\" or \"OFF\" is required.");
              System.exit(-1);
        }
     }
}

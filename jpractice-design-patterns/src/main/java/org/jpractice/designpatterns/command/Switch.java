/**
 * 
 */
package org.jpractice.designpatterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-23 21:30:35
 * @Description: The Invoker class
 * @version V1.0
 */
public class Switch {

    private List<Command> history = new ArrayList<Command>();

    public void storeAndExecute(final Command cmd) {
        this.history.add(cmd); // optional
        cmd.execute();
    }

}

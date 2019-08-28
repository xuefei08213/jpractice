/**
 * 
 */
package org.jpractice.designpatterns.state;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-07-22 00:16:14
 * @Description: TODO
 * @version V1.0
 */
public class TCPConnection {

    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    void handle() {
        state.handle(this);
    }

}

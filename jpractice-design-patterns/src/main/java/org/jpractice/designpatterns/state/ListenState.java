/**
 * 
 */
package org.jpractice.designpatterns.state;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-07-22 00:21:17
 * @Description: TODO
 * @version V1.0
 */
public class ListenState implements State {

    @Override
    public void handle(TCPConnection tcpConnection) {
        System.out.println("监听，关闭连接");
        ClosedState closedState = new ClosedState();
        tcpConnection.setState(closedState);
    }
}

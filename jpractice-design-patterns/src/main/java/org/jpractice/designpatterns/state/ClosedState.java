/**
 * 
 */
package org.jpractice.designpatterns.state;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-07-22 00:22:06
 * @Description: TODO
 * @version V1.0
 */
public class ClosedState implements State {

    @Override
    public void handle(TCPConnection tcpConnection) {
        System.out.println("连接已断开，建立连接");
        EstablishedState establishedState = new EstablishedState();
        tcpConnection.setState(establishedState);
    }
}

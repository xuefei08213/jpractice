/**
 * 
 */
package org.jpractice.designpatterns.state;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-07-22 00:14:08
 * @Description: TODO
 * @version V1.0
 */
public class EstablishedState implements State {

    @Override
    public void handle(TCPConnection tcpConnection) {
        System.out.println("连接已建立，启动监听");
        ListenState listenState = new ListenState();
        tcpConnection.setState(listenState);
    }

}

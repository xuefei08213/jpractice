/**
 * 
 */
package org.jpractice.designpatterns.state;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-07-21 15:41:18
 * @Description: TODO
 * @version V1.0
 */
public class TcpConnectionWithoutDP {

    private TCPState tcpState;

    public TcpConnectionWithoutDP(TCPState tcpState) {
        super();
        this.tcpState = tcpState;
    }

    public void handle() {

        /**
         * 使用if...else...或者switch...case...
         */
        if (tcpState == TCPState.ESTABLISHED) {
            System.out.println("连接已建立，启动监听");
            tcpState = TCPState.LISTEN;
        } else if (tcpState == TCPState.LISTEN) {
            System.out.println("监听，关闭连接");
            tcpState = TCPState.CLOSED;
        } else if (tcpState == TCPState.CLOSED) {
            System.out.println("连接关闭，建立连接");
            tcpState = TCPState.ESTABLISHED;
        }
    }

    enum TCPState {
        ESTABLISHED, LISTEN, CLOSED,
    }

}

/**
 * 
 */
package org.jpractice.designpatterns.state;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-07-21 16:18:03
 * @Description: TODO
 * @version V1.0
 */
public class TCPClient {

    public static void main(String[] args) {
        // TcpConnectionWithoutDP connection = new
        // TcpConnectionWithoutDP(TCPState.ESTABLISHED);
        // connection.handle();
        // connection.handle();
        // connection.handle();

        TCPConnection connetction = new TCPConnection();
        ClosedState closedState = new ClosedState();
        connetction.setState(closedState);

        connetction.handle();
        connetction.handle();
        connetction.handle();
    }
    /*
     * 输出如下：
     * 
     */
    // 输出如下：
    // 连接已建立，启动监听
    // 监听，关闭连接
    // 连接关闭，建立连接

}

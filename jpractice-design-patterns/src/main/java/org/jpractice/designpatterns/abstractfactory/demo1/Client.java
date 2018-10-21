/**
 * 
 */
package org.jpractice.designpatterns.abstractfactory.demo1;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-19 19:41:02
 * @Description: TODO
 * @version V1.0
 */
public class Client {

    public static void main(String[] args) {
        User user = new User();
        IFactory factory = new MysqlFactory();
        IUser userOperation = factory.createUser();

        userOperation.getUser("1");
        userOperation.insert(user);

        Login login = new Login();
        ILogin loginOperation = factory.createLogin();

        loginOperation.insert(login);
        loginOperation.getLogin(1);
    }

}

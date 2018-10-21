/**
 * 
 */
package org.jpractice.designpatterns.abstractfactory.demo1;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-19 19:39:36
 * @Description: TODO
 * @version V1.0
 */
public class MysqlFactory implements IFactory {

    @Override
    public IUser createUser() {
        // TODO Auto-generated method stub
        return new MysqlUser();
    }

    @Override
    public ILogin createLogin() {
        // TODO Auto-generated method stub
        return new MysqlLogin();
    }

}

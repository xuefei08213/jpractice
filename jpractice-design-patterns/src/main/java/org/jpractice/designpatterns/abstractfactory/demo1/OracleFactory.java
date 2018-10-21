/**
 * 
 */
package org.jpractice.designpatterns.abstractfactory.demo1;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-19 19:40:12
 * @Description: TODO
 * @version V1.0
 */
public class OracleFactory implements IFactory {

    @Override
    public IUser createUser() {
        // TODO Auto-generated method stub
        return new OracleUser();
    }

    @Override
    public ILogin createLogin() {
        // TODO Auto-generated method stub
        return new OracleLogin();
    }

}

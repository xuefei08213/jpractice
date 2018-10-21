/**
 * 
 */
package org.jpractice.designpatterns.abstractfactory.demo1;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-19 19:44:12
 * @Description: TODO
 * @version V1.0
 */
public interface ILogin {
    public void insert(Login login);

    public Login getLogin(int id);
}

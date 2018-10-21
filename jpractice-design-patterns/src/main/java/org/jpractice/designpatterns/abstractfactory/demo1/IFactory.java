/**
 * 
 */
package org.jpractice.designpatterns.abstractfactory.demo1;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-19 19:38:53
 * @Description: TODO
 * @version V1.0
 */
public interface IFactory {
    public IUser createUser();

    public ILogin createLogin();
}

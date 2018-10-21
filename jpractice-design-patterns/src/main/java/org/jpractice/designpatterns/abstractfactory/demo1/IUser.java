/**
 * 
 */
package org.jpractice.designpatterns.abstractfactory.demo1;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-19 13:58:25
 * @Description: TODO
 * @version V1.0
 */
public interface IUser {

    public void insert(User user);

    public User getUser(String userID);

}

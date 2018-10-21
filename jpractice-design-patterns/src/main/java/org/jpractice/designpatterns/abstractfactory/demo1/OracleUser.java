/**
 * 
 */
package org.jpractice.designpatterns.abstractfactory.demo1;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-19 19:37:46
 * @Description: TODO
 * @version V1.0
 */
public class OracleUser implements IUser {

    @Override
    public void insert(User user) {
        // TODO Auto-generated method stub
        System.out.println("对 Oracle 里的 User 表插入了一条数据");
    }

    @Override
    public User getUser(String userID) {
        // TODO Auto-generated method stub
        System.out.println("通过 uid 在 Oracle 里的 User 表得到了一条数据");
        return null;
    }

}

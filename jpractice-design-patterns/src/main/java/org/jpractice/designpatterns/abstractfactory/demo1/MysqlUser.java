/**
 * 
 */
package org.jpractice.designpatterns.abstractfactory.demo1;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-19 19:36:49
 * @Description: TODO
 * @version V1.0
 */
public class MysqlUser implements IUser {

    @Override
    public void insert(User user) {
        // TODO Auto-generated method stub
        System.out.println("对 MySQL 里的 User 表插入了一条数据");
    }

    @Override
    public User getUser(String userID) {
        // TODO Auto-generated method stub
        System.out.println("通过 uid 在 MySQL 里的 User 表得到了一条数据");
        return null;
    }

}

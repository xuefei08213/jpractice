/**
 * 
 */
package org.jpractice.designpatterns.abstractfactory.demo1;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-19 19:44:34
 * @Description: TODO
 * @version V1.0
 */
public class MysqlLogin implements ILogin {

    @Override
    public void insert(Login login) {
        // TODO Auto-generated method stub
        System.out.println("对 MySQL 里的 Login 表插入了一条数据");
    }

    @Override
    public Login getLogin(int id) {
        // TODO Auto-generated method stub
        System.out.println("通过 uid 在 MySQL 里的 Login 表得到了一条数据");
        return null;
    }

}

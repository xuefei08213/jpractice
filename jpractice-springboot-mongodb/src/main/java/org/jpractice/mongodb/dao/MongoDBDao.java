/**
 * 
 */
package org.jpractice.mongodb.dao;

import java.util.Map;

import org.jpractice.mongodb.entity.Customer;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-08-15 15:39:51
 * @Description: TODO
 * @version V1.0
 */
public interface MongoDBDao {

    public void insert(Customer customer);

    public void update(Map<String, Object> filter, Map<String, Object> values);

}

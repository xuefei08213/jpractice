/**
 * 
 */
package org.jpractice.mongodb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.jpractice.mongodb.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-08-15 15:41:33
 * @Description: TODO
 * @version V1.0
 */
public class MongoDBDaoImpl implements MongoDBDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(Customer customer) {
        mongoTemplate.insert(customer);
    }

    @Override
    public void update(Map<String, Object> filter, Map<String, Object> values) {

        BasicDBObject queryObject = new BasicDBObject();

        // List<Object> objects = new ArrayList<>();
        // objects.add("$firstName");
        // objects.add("55");

        DBObject equalDbObject = new BasicDBObject();
        equalDbObject.put("$eq", "55");

        DBObject nameDbObject = new BasicDBObject();
        nameDbObject.put("firstName", equalDbObject);

        List<DBObject> dbObjects = new ArrayList<>();
        dbObjects.add(nameDbObject);

        queryObject.put("$or", dbObjects);

        Document document = new Document(queryObject);
        // BasicQuery query1 = new BasicQuery(document);
        Query query = new Query(new CriteriaDefinition() {

            @Override
            public Document getCriteriaObject() {
                return document;
            }

            @Override
            public String getKey() {
                return null;
            }
        });
        Update update = new Update();
        values.forEach((key, value) -> {
            update.set(key, value);
        });

        // List<Customer> customers = mongoTemplate.find(query1, Customer.class);
        // customers.forEach(customer -> {
        // System.out.println(customer.getFirstName());
        // });

        mongoTemplate.updateMulti(query, update, "customer");

        // BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkMode.ORDERED,
        // Customer.class);
        //
        // bulkOperations.updateMulti(query1, update);
        // bulkOperations.execute();
    }

}

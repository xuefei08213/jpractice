/**
 * 
 */
package org.jpractice.mongodb.config;

import org.jpractice.mongodb.dao.MongoDBDao;
import org.jpractice.mongodb.dao.MongoDBDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-08-15 15:50:18
 * @Description: TODO
 * @version V1.0
 */
@Configuration
public class Config {

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://mcsas:Nariadmin_123@localhost:27017/mcsas");
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, "mcsas");
    }

    @Bean
    public MongoDBDao mongoDBDao() {
        return new MongoDBDaoImpl();
    }

}

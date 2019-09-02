/**
 * 
 */
package org.jpractice.mongodb.controller;

import java.util.Map;

import org.jpractice.mongodb.dao.MongoDBDao;
import org.jpractice.mongodb.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-08-15 16:04:38
 * @Description: TODO
 * @version V1.0
 */
@RestController
@RequestMapping("jpractice/mongo")
public class JMongoController {

    @Autowired
    private MongoDBDao mongoDBDao;

    @PostMapping("/insert")
    public void insert(@RequestBody Customer customer) {
        mongoDBDao.insert(customer);
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/update")
    public void update(@RequestBody Map<String, Object> param) {
        
        Map<String, Object> filter = (Map<String, Object>) param.get("filter");

        Map<String, Object> values = (Map<String, Object>) param.get("values");
        mongoDBDao.update(filter, values);
    }

}

/**
 * 
 */
package org.jpractice.springboot.h2;

import org.jpractice.springboot.h2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-09-10 19:11:31
 * @Description: TODO
 * @version V1.0
 */
@Component
public class H2CommadProcessor {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create() {
        jdbcTemplate.execute("CREATE TABLE USER (ID VARCHAR2(128),NAME VARCHAR2(128),AGE NUMBER(3))");
    }

    public void insert(User user) {
        String sql = "insert into user values (?,?,?)";
        jdbcTemplate.update(sql, user.getId(), user.getName(), user.getAge());
    }

}

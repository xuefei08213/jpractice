package org.jpractice.springboot.h2.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.h2.jdbcx.JdbcDataSource;
import org.jpractice.springboot.h2.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

public class H2Test {

    JdbcTemplate jdbcTemplate;

    @Test
    public void test() {

        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl("jdbc:h2:mem:testdb;MODE=Oracle;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        jdbcTemplate = new JdbcTemplate(dataSource);

        create();
        insert();
        User user = query("3");
        Assert.assertEquals("xuefei", user.getName());
    }

    public void create() {
        jdbcTemplate.execute("CREATE TABLE USER (ID VARCHAR2(128),NAME VARCHAR2(128),AGE NUMBER(3))");
    }

    public void insert() {
        String sql = "INSERT INTO USER VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] { "3", "xuefei", 28 });
    }

    public User query(String id) {

        User user = new User();
        String sql = "SELECT ID, NAME, AGE FROM USER WHERE ID = ?";
        jdbcTemplate.query(sql, new Object[] { id }, new RowCallbackHandler() {
            
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
            }
        });

        return user;

    }

}

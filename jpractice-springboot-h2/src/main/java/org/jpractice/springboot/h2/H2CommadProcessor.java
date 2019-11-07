/**
 * 
 */
package org.jpractice.springboot.h2;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jpractice.springboot.h2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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

    public <T> void create() {
        // jdbcTemplate.execute("CREATE TABLE USER (ID VARCHAR2(128),NAME
        // VARCHAR2(128),AGE NUMBER(3))");
        String sql = "SELECT DISTINCT a.VOLTAGELEVEL AS voltageLevel FROM CIM.ASTTRANSFORMER ast INNER JOIN CIM.OUTLINE a ON ast.ID = a.BELONGSTATION WHERE ast.VOLTAGELEVEL IS NOT NULL AND (ast.STATIONTYPE = 100 OR ast.STATIONTYPE = 131 OR ast.STATIONTYPE = 213) AND ast.VOLTAGELEVEL >= 25 AND ast.INUSESTATE = '20' AND ast.ASSETPROPERTY <> '05' AND ast.INUSEDATE IS NOT NULL  AND ast.RELEASESTATUSKIND = '2' AND a.VOLTAGELEVEL >= 22 AND a.VOLTAGELEVEL <= 37 AND a.DEPLOYMENTDATE IS NOT NULL  ORDER BY a.VOLTAGELEVEL DESC";
        jdbcTemplate.query(sql, new ResultSetExtractor<T>() {

            @Override
            public T extractData(ResultSet rs) throws SQLException, DataAccessException {
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }

                return null;
            }
        });
    }

    public void insert(User user) {
        String sql = "insert into user values (?,?,?)";
        jdbcTemplate.update(sql, user.getId(), user.getName(), user.getAge());
    }

}

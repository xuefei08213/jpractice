/**
 * 
 */
package org.jpractice.mongodb.entity;

import org.springframework.data.annotation.Id;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-08-15 15:34:09
 * @Description: TODO
 * @version V1.0
 */
public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
    }
}

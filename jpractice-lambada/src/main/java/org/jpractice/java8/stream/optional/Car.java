/**
 * 
 */
package org.jpractice.java8.stream.optional;

import java.util.Optional;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-13 06:43:30
 * @Description: TODO
 * @version V1.0
 */
public class Car {

    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }

}

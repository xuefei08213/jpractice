/**
 * 
 */
package org.jpractice.spi;

import java.time.LocalDate;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-28 15:20:31
 * @Description: TODO
 * @version V1.0
 */
public class Quote {

    private String currency;

    private LocalDate date;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}

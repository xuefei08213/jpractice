/**
 * 
 */
package org.jpractice.spi;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-28 15:29:49
 * @Description: TODO
 * @version V1.0
 */
public interface QuoteManager {

    List<Quote> getQuotes(String baseCurrency, LocalDate date);

}

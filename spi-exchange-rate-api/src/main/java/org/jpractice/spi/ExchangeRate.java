/**
 * 
 */
package org.jpractice.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-28 15:38:57
 * @Description: TODO
 * @version V1.0
 */
public class ExchangeRate {

    ServiceLoader<ExchangeRateProvider> serviceLoader = ServiceLoader.load(ExchangeRateProvider.class);

    public Iterator<ExchangeRateProvider> providers(boolean refresh) {
        if (refresh) {
            serviceLoader.reload();
        }
        return serviceLoader.iterator();
    }

}

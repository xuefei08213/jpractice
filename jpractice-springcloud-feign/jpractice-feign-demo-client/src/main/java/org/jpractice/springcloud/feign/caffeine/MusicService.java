/**
 * 
 */
package org.jpractice.springcloud.feign.caffeine;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-04 15:43:14
 * @Description: TODO
 * @version V1.0
 */
public interface MusicService {

    String play(final String instrument);

    void clearCache();

}

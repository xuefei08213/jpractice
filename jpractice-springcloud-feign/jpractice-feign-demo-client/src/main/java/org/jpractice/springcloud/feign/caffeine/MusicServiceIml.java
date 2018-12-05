/**
 * 
 */
package org.jpractice.springcloud.feign.caffeine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-04 15:44:51
 * @Description: TODO
 * @version V1.0
 */
@Service
@CacheConfig(cacheNames = { "instruments" })
public class MusicServiceIml implements MusicService {

    @Autowired
    private CacheManager cacheManager;

    private static Logger log = LogManager.getLogger(MusicServiceIml.class);

    @Cacheable
    public String play(String instrument) {
        log.info("Executing: " + this.getClass().getSimpleName() + ".play(\"" + instrument + "\");");
        return "paying " + instrument + "!";
    }

    public void clearCache() {
        cacheManager.getCacheNames().forEach(x -> System.out.println(x));
        cacheManager.getCache("instruments").clear();
    }

}

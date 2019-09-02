/**
 * 
 */
package org.jpractice.spring.session;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-11-30 11:25:36
 * @Description: TODO
 * @version V1.0
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig extends AbstractHttpSessionApplicationInitializer {
    // @Bean
    // public JedisConnectionFactory connectionFactory() {
    // return new JedisConnectionFactory();
    // }
}

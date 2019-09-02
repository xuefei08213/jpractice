/**
 * 
 */
package org.jpractice.springboot.conditional.config;

import org.jpractice.springboot.conditional.ConditionalOnBeanService;
import org.jpractice.springboot.schedule.OneMinuteTask;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-10-17 05:44:01
 * @Description: TODO
 * @version V1.0
 */
@Configuration
public class ConditionalConfig {

    @Bean
    @ConditionalOnBean(name = "test")
    public ConditionalOnBeanService conditionalOnBeanService() {
        return new ConditionalOnBeanService();
    }

    @Bean
    public OneMinuteTask oneMinuteTask() {
        return new OneMinuteTask();
    }


}

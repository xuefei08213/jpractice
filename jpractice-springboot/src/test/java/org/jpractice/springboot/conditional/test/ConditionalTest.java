/// ****/package org.jpractice.springboot.conditional.test;
//
// import static org.assertj.core.api.Assertions.assertThat;
//
// import org.jpractice.springboot.conditional.ConditionalOnBeanService;
// import org.jpractice.springboot.conditional.MyService;
// import org.junit.Test;
// import org.springframework.boot.autoconfigure.AutoConfigurations;
// import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
// import org.springframework.boot.test.context.runner.ApplicationContextRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
/// ***
//
// @author
// :作者：xuefei*@date
// :创建时间：2018-10-17 05:52:25*@Description
// :TODO*@version
// V1.0*/public class ConditionalTest {
//
// private final ApplicationContextRunner
/// contextRunner=new/ApplicationContextRunner().withConfiguration(AutoConfigurations.of(UserConfiguration.class));
//
// @Test
// public void defaultServiceBacksOff() {
// this.contextRunner.withUserConfiguration(UserConfiguration.class).run((context)
/// -> {
// assertThat(context).hasSingleBean(ConditionalOnBeanService.class);
// assertThat(context).hasSingleBean(MyService.class);
// assertThat(context.getBean(MyService.class))
// .isSameAs(context.getBean(UserConfiguration.class).myUserService());
//
// });
// }
//
// @Configuration
// static class UserConfiguration {
//
// @Bean
// @ConditionalOnBean(name = "test")
// public ConditionalOnBeanService conditionalOnBeanService() {
// return new ConditionalOnBeanService();
// }
//
// @Bean
// public MyService myUserService() {
// return new MyService();
// }
//
// }
//
// }

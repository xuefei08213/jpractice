/// **
// *
// */
// package org.jpractice.spring.session;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import
/// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
/// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
/// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
/// **
// * @author: 作者： xuefei
// * @date: 创建时间：2018-11-30 11:24:58
// * @Description: TODO
// * @version V1.0
// */
// @Configuration
// public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
// @Autowired
// public void configureGlobal(AuthenticationManagerBuilder auth) throws
/// Exception {
// auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
// }
//
// @Override
// protected void configure(HttpSecurity http) throws Exception {
// http.httpBasic().and().authorizeRequests().antMatchers("/").hasRole("ADMIN").anyRequest().authenticated();
// }
// }

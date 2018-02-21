/*package com.storeArticle.store.controller.config;*/

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;


//@EnableWebSecurity
//@Configuration
//@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
//        RequestMethod.DELETE })
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//
//                .withUser("ajay").password("test").roles("USER").and()
//                .withUser("demo").password("test2").roles("ADMIN");
//    }
//
//    @Override
//    public void configure(HttpSecurity httpSecurity) throws Exception {
//
//        httpSecurity
//                .authorizeRequests()
//                .anyRequest()
//                .fullyAuthenticated()
//              //  .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
//                //.antMatchers("**/rest/*")
//                .and()
//                //.addFilterBefore(customFilter(), BasicAuthenticationFilter.class)
//                .httpBasic();
//        httpSecurity.csrf().disable();
//
//    }
//
//    @Bean
//    public CustomFilter customFilter() {
//        return new CustomFilter();
//    }
//}

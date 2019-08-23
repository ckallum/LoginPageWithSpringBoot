package com.example.loginwebapp.config;

import com.example.loginwebapp.service.impl.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.annotation.Resource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private AccessDeniedHandler accessDeniedHandler;

    @Resource
    private AppUserService userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/home","/about").permitAll()
                    .antMatchers("/user").hasAnyRole("USER", "ADMIN")
                    .antMatchers("/admin").hasAnyRole("ADMIN")
                    .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginProcessingUrl("/j_spring_security_check")
                    .loginPage("/login")
                    .defaultSuccessUrl("/user")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .permitAll()
                    .and()
                .logout()
                    .logoutSuccessUrl("/logoutsuccess")
                    .permitAll()
                    .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }
//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth
////                .userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
////        .inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER")
////                .and()
////                .withUser("admin").password("{noop}password").roles("ADMIN");
//

//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}

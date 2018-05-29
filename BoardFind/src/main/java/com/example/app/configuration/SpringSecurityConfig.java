package com.example.app.Configuration;

import com.example.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
<<<<<<< HEAD

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
=======
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer{
>>>>>>> aa09e9c6da84b7495e14c8669ded727bad604ae8

    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService).passwordEncoder(getBCryptPasswordEncoder());

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/","/register", "/login").permitAll()
<<<<<<< HEAD
                .antMatchers("/resources/**").permitAll()
=======
>>>>>>> aa09e9c6da84b7495e14c8669ded727bad604ae8
                .antMatchers("/user/**").access("hasRole('USER') OR hasRole('ADMIN')")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                    .rememberMe()
                    .rememberMeCookieName("TheBoardFinders")
                    .rememberMeParameter("remember")
                    .key("1random%2316secretcryptoTUES")
                    .tokenValiditySeconds(2629743)
                .and()
                    .logout().logoutSuccessUrl("/login?logout").permitAll()
                .and()
                    .exceptionHandling().accessDeniedPage("/unauthorized")
                .and()
                    .csrf().disable();
    }

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

}
package com.example.basic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("1234").roles("ADMIN").and()
                .withUser("user").password("1234").roles("USER").and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic().disable();

            http.csrf().ignoringAntMatchers("/api/**").and().authorizeRequests().
                        mvcMatchers("/login*").permitAll()
                    .mvcMatchers("/").permitAll()
                    .mvcMatchers("/signup").permitAll()
                    .mvcMatchers("/write").permitAll()
                    .mvcMatchers("/api/**").authenticated().and()
                    .formLogin().loginPage("/login").defaultSuccessUrl("/write").failureUrl("/login?error=true").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll().and().httpBasic()
                ;
    }
}

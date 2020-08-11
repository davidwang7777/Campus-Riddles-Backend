package com.SobreMesa.Campus.Riddles.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.SobreMesa.Campus.Riddles.Services.UserDetailsServiceImpl;
import com.SobreMesa.Campus.Riddles.repo.HunterRepository;

import lombok.AllArgsConstructor;

@EnableJpaRepositories(basePackageClasses = HunterRepository.class)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService){
      this.userDetailsService = userDetailsService;
    }   

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity 
        .cors().and()
        .csrf().disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/api/**")
        .permitAll()
        .antMatchers("/api/**")
        .permitAll()
        .antMatchers(HttpMethod.GET, "/api/posts/")
        .permitAll()
        .antMatchers(HttpMethod.GET, "/api/posts/**")
        .permitAll()
        // change the bottom matchers to my site's urls
        .antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**")
        .permitAll()
        .anyRequest()
        .authenticated();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManager) throws Exception 
   {
        authenticationManager.userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        /*
         * passwordEncoder is part of spring security. it is used to encrypt passwords with a 
         * BCrypt hashing algorithm
         */
        return new BCryptPasswordEncoder();
    }
}
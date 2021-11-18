package com.yega.mlc.security;

import com.yega.mlc.constants.JwtConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

      @Autowired
      private UserDetailsService userDetailsService;

      @Autowired
      private JwtAuthorizationFilter jwtAuthorizationFilter;

      @Autowired
      private JwtAuthenticationEntryPoint unauthorizedHandler;

      @Override
      protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
      }

      @Override
      protected void configure(HttpSecurity http) throws Exception {
            http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                        .authorizeRequests().antMatchers(JwtConstants.AUTHORIZE_REQUESTS).permitAll().anyRequest().authenticated()
                        .and().addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

      }

      @Bean
      public PasswordEncoder getPasswordEncoder() {
            return new BCryptPasswordEncoder();
      }

      @Bean
      @Override
      public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
      }

}

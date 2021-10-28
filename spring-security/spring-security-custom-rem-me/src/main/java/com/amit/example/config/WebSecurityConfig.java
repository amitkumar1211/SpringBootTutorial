package com.amit.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withDefaultPasswordEncoder().username("amit").password("amit").roles("ADMIN").build());
		manager.createUser(User.withDefaultPasswordEncoder().username("sumit").password("sumit").roles("USER").build());
		return manager;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.authorizeRequests().antMatchers("/users").permitAll()
		.antMatchers("/users/user").hasRole("USER")
		.antMatchers("/admin").hasRole("ADMIN")
		.and().formLogin()
		.and().rememberMe().key("rem-amit-key")
		.rememberMeParameter("rememberAmit")
		.rememberMeCookieName("rememberAmit")
		.tokenValiditySeconds(100);
	}

}

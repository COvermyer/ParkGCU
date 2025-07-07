package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gcu.business.UserBusinessService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	UserBusinessService service;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		return http.csrf(csrf -> csrf.disable())
				.userDetailsService(service)
				.authorizeHttpRequests(authz -> authz
						.requestMatchers("/services/**").authenticated()
						.requestMatchers("/", "/customers/new", "/stylesheets/**", "/images/**", "/displayOauthCose").permitAll()
						.anyRequest().authenticated()
				)
				.formLogin(login -> login
						.loginPage("/login")
						.usernameParameter("username")
						.passwordParameter("password")
						.permitAll()
						.defaultSuccessUrl("/customers/all", true)
				)
				.logout(logout -> logout
						.logoutUrl("/logout")
						.invalidateHttpSession(true)
						.clearAuthentication(true)
						.permitAll()
						.logoutSuccessUrl("/login")
				)
				.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}

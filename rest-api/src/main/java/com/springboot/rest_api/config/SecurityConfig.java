package com.springboot.rest_api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.springboot.rest_api.service.MyUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
 	private MyUserService myUserService;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf(csrf->csrf.disable())
			.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers("/api/customer/public/hello").permitAll()
				.requestMatchers("/api/customer/private/hello").authenticated()
				.requestMatchers("/api/auth/signup").permitAll()
				.requestMatchers("/api/auth/login").authenticated()
				.requestMatchers("/api/product/image/upload/{pid}").hasAnyAuthority("VENDOR","ADMIN")
				.anyRequest().authenticated()
			)
			
			.authenticationProvider(getAuth())
			/* Activating basic Auth */
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
//	@Bean
//	UserDetailsService userDetailsService() {
//		
//		User user1 = (User) User.withUsername("harry")
//						.password("{noop}potter")
//						.roles("USER_DEFAULT")
//						.build();
//		
//		User user2 = (User) User.withUsername("john")
//						.password("{noop}doe")
//						.roles("USER_DEFAULT")
//						.build();
//		 
//		return new InMemoryUserDetailsManager(user1,user2);
//	}
	
	@Bean
	AuthenticationProvider getAuth() {
 		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
 		dao.setPasswordEncoder(passEncoder());
 		dao.setUserDetailsService(myUserService);	
 		return dao;
 	}
 
	
	@Bean
 	BCryptPasswordEncoder passEncoder(){
 		return new BCryptPasswordEncoder();
 	}
	
}
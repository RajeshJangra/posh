package com.xebia.hr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.xebia.hr.security.AuthenticationTokenFilter;
import com.xebia.hr.security.EntryPointUnauthorizedHandler;
import com.xebia.hr.service.InductionUserDetailsService;

/**
 * @author gauravagrawal
 * @since 18 July, 16
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private EntryPointUnauthorizedHandler unauthorizedHandler;

	@Autowired
	private InductionUserDetailsService inductionUserDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.inductionUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.csrf()
				.disable()
			.exceptionHandling()
				.authenticationEntryPoint(this.unauthorizedHandler)
			.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.authorizeRequests()
				.antMatchers("/auth/**").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll() //Added to fix CORS issue
				.anyRequest().authenticated();

		// Custom JWT based authentication
		httpSecurity
			.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public AuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
		AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
		authenticationTokenFilter.setAuthenticationManager(authenticationManagerBean());
		return authenticationTokenFilter;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}

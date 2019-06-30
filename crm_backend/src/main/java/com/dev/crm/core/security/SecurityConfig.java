package com.dev.crm.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	@Qualifier("userDetailService")
	private UserDetailServiceImpl userDetailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests()
						.antMatchers("/").permitAll()
						.antMatchers("/resources/**", "/static/**", "/assets/**").permitAll()
						.antMatchers("/login").permitAll()
						.antMatchers("/dashboard").authenticated()
						.anyRequest().authenticated()
						.and()
						.formLogin()
						.loginPage("/login")
						.loginProcessingUrl("/login")
						.successHandler(successHandler)
						.defaultSuccessUrl("/dashboard", true)
						.failureUrl("/login?error=true")
						.usernameParameter("username")
						.passwordParameter("password")
						.and()
						.logout()
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.logoutSuccessUrl("/login")
						.deleteCookies("JSESSIONID")
						.and()
						.exceptionHandling().accessDeniedPage("/404");
		
		http.sessionManagement()
		  .invalidSessionUrl("/login");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
}

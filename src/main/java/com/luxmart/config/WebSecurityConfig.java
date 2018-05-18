package com.luxmart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		
		auth
		.inMemoryAuthentication()
		.withUser("admin").password("admin").roles("ADMIN", "USER")
		.and().withUser("user").password("user").roles("USER");
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
       
        
            .antMatchers("/", "/index", "/index/**").permitAll()           
            .antMatchers("/checkout", "/docheckout").permitAll()
                     
            .antMatchers("/", "/secured").permitAll()
            .antMatchers("/login", "logout").permitAll()                                 
            .antMatchers("/static/**","/css/**", "/js/**","/bootstrap/**", "/images/**", "/**/favicon.ico").permitAll()

            
            .anyRequest().fullyAuthenticated()
        	  .and()
        	    .formLogin()
        	    .loginPage("/login").permitAll()  
        	    .failureUrl("/login?error").permitAll()
        	    .defaultSuccessUrl("/index").permitAll()        	    
        	    .usernameParameter("username").passwordParameter("password")        	    
        	  .and()	  
        	    .logout()
        	    .deleteCookies("remove")
        	    .invalidateHttpSession(true)
        	    .logoutUrl("/logout")
        	    .logoutSuccessUrl("/logout-success")
        	    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        	   .and()
        	   .exceptionHandling().accessDeniedPage("/403");
        
        http.csrf().disable();

    }
	
}

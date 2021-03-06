package com.luxmart.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

// configuration for internationalization
@Configuration
public class I18N  extends WebMvcConfigurerAdapter{
	
	@Bean
	public SessionLocaleResolver localeResolver(){
		
		SessionLocaleResolver sessionLocaleResolver  = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.CANADA);
		return sessionLocaleResolver;
				
		
	}
	
	@Bean
	LocaleChangeInterceptor localeChangeInterceptor(){		
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
		 
	}

	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry)
	{
		interceptorRegistry.addInterceptor(localeChangeInterceptor());
		
	}
	
}

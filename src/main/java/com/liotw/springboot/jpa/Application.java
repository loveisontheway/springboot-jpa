package com.liotw.springboot.jpa;

import com.liotw.springboot.jpa.filter.ServiceFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//这个Filter  解决页面跨域访问问题
	@Bean
	public FilterRegistrationBean omsFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new ServiceFilter());
		registration.addUrlPatterns("/*");
		//registration.addInitParameter("paramName", "paramValue");
		registration.setName("MyFilter");
		registration.setOrder(1);
		return registration;
	}
}

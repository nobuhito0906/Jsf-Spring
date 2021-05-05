package com.example;

import javax.faces.webapp.FacesServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = { JsfSpringApplication.class })
public class JsfSpringApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(JsfSpringApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		ServletRegistrationBean<FacesServlet> servletRegistrationBean = new ServletRegistrationBean<FacesServlet>(
				servlet, "*.jsf");

		return servletRegistrationBean;
	}
}

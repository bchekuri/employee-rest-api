package com.bc.cofig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({ @PropertySource("env/${process.env}/application-${process.env}.properties") })
@ComponentScan(basePackages = {"com.bc"})
public class ApplicationConfig {
	
}

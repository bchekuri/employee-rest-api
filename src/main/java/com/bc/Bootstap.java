package com.bc;

import static com.bc.util.Constants.APPLICATION_START_MSG;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@EnableAutoConfiguration
public class Bootstap {
	
	public final static Logger logger = LoggerFactory.getLogger(Bootstap.class);
	
	
	public static void main(String[] args) {
         ApplicationContext applicationContext = SpringApplication.run(Bootstap.class, args);
         printApplicationContextBean(applicationContext);
         logger.info(APPLICATION_START_MSG);
    }
	
	public static void printApplicationContextBean(ApplicationContext applicationContext) {
		List<String> beanNames = Arrays.asList(applicationContext.getBeanDefinitionNames());
		beanNames.stream().forEach(beanName -> logger.debug("Bean Name :: " + beanName));
	}
	
}

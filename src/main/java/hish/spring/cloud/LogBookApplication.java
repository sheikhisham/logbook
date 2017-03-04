package hish.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import hish.spring.cloud.config.RibbonLBConfiguration;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "logbook", configuration = RibbonLBConfiguration.class)
public class LogBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogBookApplication.class, args);
	}
}

package pl.ttpsc.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


//https://spring.io/blog/2015/07/14/microservices-with-spring

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryMicroserviceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryMicroserviceServerApplication.class, args);
	}
}

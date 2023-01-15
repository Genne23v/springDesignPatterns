package com.wonkeun.springDesignPattern;

import com.wonkeun.springDesignPattern.prototype.ProtoFalse;
import com.wonkeun.springDesignPattern.prototype.ProtoTrue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringDesignPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDesignPatternApplication.class, args);
	}

	@Bean
	public ProtoFalse protoFalse() {
		return new ProtoFalse();
	}

	@Bean
	@Scope("prototype")
	public ProtoTrue protoTrue() {
		return new ProtoTrue();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

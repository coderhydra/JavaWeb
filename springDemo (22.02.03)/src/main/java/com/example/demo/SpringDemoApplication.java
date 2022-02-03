package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		//스프링 웹을 돌이면 이부분 실행된다. 
		System.err.println("스프일 웹 시작");
		SpringApplication.run(SpringDemoApplication.class, args);
	}
	
	@Bean
  public ServerEndpointExporter serverEndpointExporter() {
      return new ServerEndpointExporter();
  }
}

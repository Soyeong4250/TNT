package com.example.demo.Service;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService{
		
	WebClient webClient = WebClient.builder().build();
	@Override
	public Mono<String> getUserNaverInfo(String token) {
		
		try {
			return webClient.post()
					.uri("naverAddress")
					.header(HttpHeaders.AUTHORIZATION, "naverToken")
					.retrieve()
					.bodyToMono(String.class);			
		} catch (Exception e) {
			 return null;
		}
		
	}

}

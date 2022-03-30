package com.example.demo.Service;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

public interface UserService {
	Mono<String> getUserNaverInfo(String token);
}

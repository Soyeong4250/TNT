package com.ssafy.tnt.api.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.ssafy.tnt.db.repository.KeywordRedisRepository;

@Service
public class KeywordServiceImpl implements KeywordService {
	
//	stringRedisTemplate bean은 일반적인 String 값을 key, value로 사용하는 경우 사용하면 된다.
//	redisTemplate bean은 java Object를 redis에 저장하는 경우 사용하면 된다.
	private String key = "keyword";
	private int size = 9; // 가져올 실시간 검색어 순위 개수 (10개) -> 0 ~ size까지
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	KeywordRedisRepository keywordRedisRepository;
	
	@Override
	public Set<String> findKeyword() {
		return redisTemplate.opsForZSet().range(this.key, 0, this.size);
	}
}

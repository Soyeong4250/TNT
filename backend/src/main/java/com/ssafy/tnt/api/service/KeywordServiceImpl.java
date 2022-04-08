package com.ssafy.tnt.api.service;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.ssafy.tnt.db.entity.KeywordEntity;
import com.ssafy.tnt.db.repository.KeywordRedisRepository;
import com.ssafy.tnt.db.repository.KeywordRepository;

@Service
public class KeywordServiceImpl implements KeywordService {
	
//	stringRedisTemplate bean은 일반적인 String 값을 key, value로 사용하는 경우 사용하면 된다.
//	redisTemplate bean은 java Object를 redis에 저장하는 경우 사용하면 된다.
	private String key = "keyword";
	private int size = 49; // 가져올 실시간 검색어 순위 개수 (10개) -> 0 ~ size까지
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	KeywordRepository keywordRepository;
	
	@Autowired
	KeywordRedisRepository keywordRedisRepository;
	
	

	@Override
	public KeywordEntity findKeywordRank(String word) {
		return keywordRepository.findByWordOrderByDate(word);
	}



	@Override
	public LinkedHashMap<String, Integer> findKeyword() {
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>(); 
		Set<String> keywordSet = redisTemplate.opsForZSet().range(this.key, 0, this.size);
		System.out.println(keywordSet.size());
		Iterator<String> iter = keywordSet.iterator();
		while(iter.hasNext()) {
			String value = iter.next();
			int score = Integer.parseInt(String.valueOf(Math.round(redisTemplate.opsForZSet().score(key, value)*-1)));			
			lhm.put(value, score);
		}	
		
		return lhm;
	}
	private static class Keyword{
		String keyword;
		int count;
		public Keyword(String keyword, int count) {
			super();
			this.keyword = keyword;
			this.count = count;
		}
	}
}

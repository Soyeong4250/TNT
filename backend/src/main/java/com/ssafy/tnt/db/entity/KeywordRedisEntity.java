package com.ssafy.tnt.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.Setter;

@RedisHash("keyword")
@Getter
@Setter
public class KeywordRedisEntity {
	@Id
	private String keyword;
	private double rank;
	
	public KeywordRedisEntity(String keyword, double rank) {
		super();
		this.keyword = keyword;
		this.rank = rank;
	}
}

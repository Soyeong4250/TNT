package com.ssafy.tnt.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.tnt.db.entity.KeywordRedisEntity;

@Repository
public interface KeywordRedisRepository extends CrudRepository<KeywordRedisEntity, String>{
}

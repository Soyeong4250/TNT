package com.ssafy.tnt.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.tnt.db.entity.KeywordEntity;

public interface KeywordRepository extends JpaRepository<KeywordEntity, Integer>{
	KeywordEntity findByWordOrderByDate(String word);
}

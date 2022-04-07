package com.ssafy.tnt.api.service;


import java.util.LinkedHashMap;

import com.ssafy.tnt.db.entity.KeywordEntity;


public interface KeywordService {
	LinkedHashMap<String, Integer> findKeyword();
	KeywordEntity findKeywordRank(String word);
}

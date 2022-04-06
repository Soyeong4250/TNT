package com.ssafy.tnt.api.service;


import java.util.Set;

import com.ssafy.tnt.db.entity.KeywordEntity;


public interface KeywordService {
	Set<String> findKeyword();
	KeywordEntity findKeywordRank(String word);
}

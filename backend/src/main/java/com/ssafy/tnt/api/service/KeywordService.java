package com.ssafy.tnt.api.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ssafy.tnt.db.entity.KeywordEntity;


public interface KeywordService {
	TreeMap<Integer, String> findKeyword();
	KeywordEntity findKeywordRank(String word);
}

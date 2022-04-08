package com.ssafy.tnt.api.controller;

import java.util.LinkedHashMap;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tnt.api.service.KeywordService;
import com.ssafy.tnt.db.entity.KeywordEntity;

@RestController
@RequestMapping("/api/keyword")
public class KeywordController {
	
	@Autowired
	KeywordService keywordService;
	
	@GetMapping()
	public ResponseEntity<LinkedHashMap<String, Integer>> findKeyword() {
		return new ResponseEntity<> (keywordService.findKeyword(), HttpStatus.OK);
	}
	
	@GetMapping("/rank")
	public ResponseEntity<KeywordEntity> findKeywordRank(@RequestParam(name="keyword") String word){
		return new ResponseEntity<>(keywordService.findKeywordRank(word),HttpStatus.OK);
	}
}

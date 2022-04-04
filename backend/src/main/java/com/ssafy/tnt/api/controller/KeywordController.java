package com.ssafy.tnt.api.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tnt.api.service.KeywordService;

@RestController
@RequestMapping("/api/keyword")
public class KeywordController {
	
	@Autowired
	KeywordService keywordService;
	
	@GetMapping()
	public ResponseEntity<Set<String>> findKeyword() {
		return new ResponseEntity<> (keywordService.findKeyword(), HttpStatus.OK);
	}
}

package com.ssafy.tnt.api.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tnt.api.service.NewsService;
import com.ssafy.tnt.db.entity.News;

@RestController
@RequestMapping("/api/news")
public class NewsController {
	
	@Autowired
	NewsService newsService;
	
	@GetMapping("/find/category")
	public ResponseEntity<Page<News>> findNewsByCategory(@RequestParam(name="category") String category, @RequestParam(name="page") int page){
		return new ResponseEntity<>(newsService.findByCategory(category, page), HttpStatus.OK);			
	}
	@GetMapping("find/title")
	public ResponseEntity<Page<News>> findNewsByTitle(@RequestParam(name="title") String title, @RequestParam(name="page") int page){
		return new ResponseEntity<>(newsService.findByTitle(title, page), HttpStatus.OK);			
	}
	@GetMapping("find/content")
	public ResponseEntity<Page<News>> findNewsByContent(@RequestParam(name="content") String content, @RequestParam(name="page") int page){
		return new ResponseEntity<>(newsService.findByContent(content, page), HttpStatus.OK);			
	}
	@GetMapping("find/company")
	public ResponseEntity<Page<News>> findNewsByCompany(@RequestParam(name="company") String company, @RequestParam(name="page") int page){
		return new ResponseEntity<>(newsService.findByCompany(company, page), HttpStatus.OK);
	}
	
	@GetMapping("find/category/count")
	public ResponseEntity<List<Map<String,Object>>> findCategoryCount(){
		return new ResponseEntity<>(newsService.findCategoryCount(), HttpStatus.OK);		
	}
}

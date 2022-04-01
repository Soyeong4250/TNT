package com.ssafy.tnt.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/find")
	public ResponseEntity<Page<News>> findNews(@RequestParam(name="category") String category, @RequestParam(name="page") int page){
		System.out.println(category);
		return new ResponseEntity<>(newsService.findByCategory(category, page), HttpStatus.OK);
				
	}
}

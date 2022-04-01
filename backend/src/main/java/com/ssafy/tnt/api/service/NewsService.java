package com.ssafy.tnt.api.service;

import org.springframework.data.domain.Page;

import com.ssafy.tnt.db.entity.News;

public interface NewsService {
	Page<News> findByCategory(String category, int page);
}
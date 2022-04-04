package com.ssafy.tnt.db.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.tnt.db.entity.News;

public interface NewsRepository extends JpaRepository<News, Long>{
	Page<News> findByCategoryContainingOrderByDateDesc(String category, Pageable pageable);
	Page<News> findByTitleContainingOrderByDateDesc(String title, Pageable pageable);
	Page<News> findByContentContainingOrderByDateDesc(String content, Pageable pageable);
}

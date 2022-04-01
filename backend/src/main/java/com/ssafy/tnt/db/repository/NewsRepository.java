package com.ssafy.tnt.db.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.tnt.db.entity.News;

public interface NewsRepository extends JpaRepository<News, Long>{
	Page<News> findByCategoryContainingOrderByNoDesc(String category, Pageable pageable);
	Page<News> findByTitleContainingOrderByNoDesc(String title, Pageable pageable);
	Page<News> findByContentContainingOrderByNoDesc(String content, Pageable pageable);
}

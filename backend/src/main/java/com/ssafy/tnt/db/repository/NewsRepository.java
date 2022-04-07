package com.ssafy.tnt.db.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ssafy.tnt.db.entity.News;

public interface NewsRepository extends JpaRepository<News, Long>{
	Page<News> findByCategoryContainingOrderByDateDesc(String category, Pageable pageable);
	Page<News> findByTitleContainingOrderByDateDesc(String title, Pageable pageable);
	Page<News> findByContentContainingOrderByDateDesc(String content, Pageable pageable);
	Page<News> findByCompanyContainingOrderByDateDesc(String company, Pageable pageable);
	
	@Query(value = "select news_category, count(*) as count from news group by(news_category)", nativeQuery=true)
	public List<Map<String, Object>> findCategoryCount();
}

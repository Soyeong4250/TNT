package com.example.demo.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.db.entity.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer>{
	// Notice findById(int no);
}

package com.ssafy.tnt.db.repository;

import com.ssafy.tnt.db.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long>{
	// Notice findById(int no);
}

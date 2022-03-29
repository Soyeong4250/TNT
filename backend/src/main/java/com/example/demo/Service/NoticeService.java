package com.example.demo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.db.entity.Notice;
import com.example.demo.db.entity.NoticeDTO;

public interface NoticeService {

	public List<Notice> findAllNotice();
	public Notice registNotice(NoticeDTO noticeDto);
	public Notice modifyNotice(NoticeDTO noticeDto);
	public Notice deleteNotice(int notice_no);
//	Notice findByNo(int no);
}

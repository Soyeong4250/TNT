package com.ssafy.tnt.api.service;

import com.ssafy.tnt.db.entity.Notice;
import com.ssafy.tnt.db.entity.NoticeDTO;
import com.ssafy.tnt.db.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeRepository noticeRepository;

	@Override
	public List<Notice> findAllNotice() {
		return noticeRepository.findAll();
	}
//	@Override
//	public Notice findByNo(int no) {
//		try {
//			Notice notice = noticeRepository.findById(no);
//			return notice;
//		}catch(Exception e) {
//			return null;
//		}
//
//	}

	@Override
	public Notice registNotice(NoticeDTO noticeDto) {
		Notice notice = new Notice(noticeDto.getTitle(), noticeDto.getWriter(), noticeDto.getContent());
		noticeRepository.save(notice);
		return notice;
	}

	@Override
	public Notice modifyNotice(NoticeDTO noticeDto) {
//		Notice notice = findByNo(noticeDto.getNo());
		Notice notice = noticeRepository.findById(noticeDto.getNo()).orElseThrow(() -> new IllegalArgumentException("no such data"));
		notice.update(noticeDto.getTitle(), noticeDto.getContent());

//		Notice notice = findByNo(noticeDto.getNo());
//		notice.setTitle(noticeDto.getTitle());
//		notice.setContent(noticeDto.getContent());
//		noticeRepository.save(notice);
		return notice;
	}

	@Override
	public Notice deleteNotice(int notice_no) {
//		Notice notice = findByNo(notice_no);
		Notice notice = noticeRepository.findById(notice_no).orElseThrow(() -> new IllegalArgumentException("no such data"));
		noticeRepository.delete(notice);
		return notice;
	}


}

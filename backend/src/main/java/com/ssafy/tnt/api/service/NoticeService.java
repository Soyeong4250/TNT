package com.ssafy.tnt.api.service;


import com.ssafy.tnt.db.entity.Notice;
import com.ssafy.tnt.db.entity.NoticeDTO;

import java.util.List;

public interface NoticeService {

	public List<Notice> findAllNotice();
	public Notice registNotice(NoticeDTO noticeDto);
	public Notice modifyNotice(NoticeDTO noticeDto);
	public Notice deleteNotice(Long notice_no);
//	Notice findByNo(int no);
}

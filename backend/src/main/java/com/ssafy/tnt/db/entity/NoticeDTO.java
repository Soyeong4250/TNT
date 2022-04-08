package com.ssafy.tnt.db.entity;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {
	private Long no;
	private String title;	
	private Long writer;
	private String content;
	private LocalDateTime date;

//	private Long userPkId;
	private String userName;

	public NoticeDTO(String title, Long writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	@QueryProjection
	public NoticeDTO(Notice notice, User user) {
		no = notice.getNo();
		title = notice.getTitle();
		content = notice.getContent();
		date = notice.getDate();

		writer = user.getId();
		userName = user.getName();
	}
}

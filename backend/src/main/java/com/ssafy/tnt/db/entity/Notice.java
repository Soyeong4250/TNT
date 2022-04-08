package com.ssafy.tnt.db.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="notice")
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Notice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="notice_no")
	private Long no;
	@Column(name="notice_title")
	private String title;
	@Column(name="notice_writer")
	private Long writer;
	@Column(name="notice_content")
	private String content;
	@Column(name="notice_date")	
	private LocalDateTime date;
	
	
	@Builder
	public Notice(NoticeDTO noticeDTO) {
		this.title = noticeDTO.getTitle();
		this.content = noticeDTO.getContent();
		this.writer = noticeDTO.getWriter();
	}
	
	public void update(NoticeDTO noticeDTO) {
		this.title = noticeDTO.getTitle();
		this.content = noticeDTO.getContent();
	}
	
	@PrePersist
	public void createdAt(){
		this.date = LocalDateTime.now();
	}

	public Notice(Long no, String title, Long writer, String content, LocalDateTime date) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.date = date;
	}
}

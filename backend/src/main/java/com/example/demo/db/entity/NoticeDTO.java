package com.example.demo.db.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {
	private int no;
	private String title;	
	private String writer;
	private String content;
	private Date date;

	public NoticeDTO(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
}

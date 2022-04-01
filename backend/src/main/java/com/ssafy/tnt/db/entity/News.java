package com.ssafy.tnt.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
@NoArgsConstructor
public class News {
	@Id
	@Column(name="news_no")
	private long no;
	
	@Column(name="news_title")
	private String title;
	
	@Column(name="news_category")
	private String category;
	
	@Column(name="news_date")
	private Date date;
	
	@Column(name="news_reporter")
	private String reporter;
	
	@Lob
	@Column(name="news_content", length=5000)
	private String content;
	
	@Column(name="news_company")
	private String company;
	
	@Column(name="news_thumbnail_url")
	private String tumbnailUrl;
	
	@Column(name="news_origin_url")
	private String newsUrl;
	
	
	
	public News(long no, String category) {
		super();
		this.no = no;
		this.category = category;
	}

	public News(long no, String title, String category, Date date, String reporter, String content, String company,
			String tumbnailUrl, String newsUrl) {
		super();
		this.no = no;
		this.title = title;
		this.category = category;
		this.date = date;
		this.reporter = reporter;
		this.content = content;
		this.company = company;
		this.tumbnailUrl = tumbnailUrl;
		this.newsUrl = newsUrl;
	}
}

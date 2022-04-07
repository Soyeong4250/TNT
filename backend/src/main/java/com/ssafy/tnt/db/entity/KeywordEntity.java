package com.ssafy.tnt.db.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="keyword")
@NoArgsConstructor
public class KeywordEntity {
	@Id
	@Column(name="keyword_no")
	int no;	
	@Column(name="keyword_count")
	int count;
	@Column(name="keyword_date")
	LocalDate date;
	@Column(name="keyword_word")
	String word;
}

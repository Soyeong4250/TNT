package com.ssafy.tnt.api.controller;

import com.ssafy.tnt.api.service.NoticeService;
import com.ssafy.tnt.db.entity.Notice;
import com.ssafy.tnt.db.entity.NoticeDTO;
import com.ssafy.tnt.db.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	@Autowired
	private NoticeRepository noticeRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Notice>> findAllNotice(){
		System.out.println("접속");
		return new ResponseEntity<>(noticeService.findAllNotice(), HttpStatus.OK);
	}
	@GetMapping()
	public ResponseEntity<Notice> findByNoNotice(@RequestParam("no") int no) {
		Notice notice = noticeRepository.findById(no).orElseThrow(() -> new IllegalArgumentException("no such data"));
		return new ResponseEntity<>(notice, HttpStatus.OK);
	}
	@PostMapping("/regist")
	public ResponseEntity<Notice> registNotice(@RequestBody NoticeDTO noticeDto){
		return new ResponseEntity<>(noticeService.registNotice(noticeDto), HttpStatus.OK);
	}
	@PutMapping("/modify")
	public ResponseEntity<Notice> modifyNotice(@RequestBody NoticeDTO noticeDto){
		return new ResponseEntity<>(noticeService.modifyNotice(noticeDto), HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Notice> deleteNotice(@RequestParam("no") int no){
		return new ResponseEntity<>(noticeService.deleteNotice(no), HttpStatus.OK);
	}
	
}

package com.ssafy.tnt.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ssafy.tnt.db.entity.News;
import com.ssafy.tnt.db.repository.NewsRepository;

@Service
public class NewsServiceImpl implements NewsService{
	@Autowired
	NewsRepository newsRepository;

	int size = 13; // 한 페이지에 제공할 개수
	
	@Override
	public Page<News> findByCategory(String category, int page) {
		PageRequest pageRequest = PageRequest.of(page, this.size);
		return newsRepository.findByCategoryContainingOrderByDateDesc(category, pageRequest);
	}
	@Override
	public Page<News> findByTitle(String title, int page) {
		PageRequest pageRequest = PageRequest.of(page, this.size);
		return newsRepository.findByTitleContainingOrderByDateDesc(title, pageRequest);
	}
	@Override
	public Page<News> findByContent(String content, int page) {
		PageRequest pageRequest = PageRequest.of(page, this.size);
		return newsRepository.findByContentContainingOrderByDateDesc(content, pageRequest);
	}
	@Override
	public Page<News> findByCompany(String company, int page) {
		PageRequest pageRequest = PageRequest.of(page, this.size);
		return newsRepository.findByCompanyContainingOrderByDateDesc(company, pageRequest);
	}
	@Override
	public HashMap<String, Integer> findCategoryCount() {
		List<Map<String,Object>> listMap = newsRepository.findCategoryCount();
		StringTokenizer st;
		HashMap<String, Integer> resultMap = new HashMap<>();
		resultMap.put("전체",0);
		resultMap.put("정치",0);
		resultMap.put("경제",0);
		resultMap.put("사회",0);
		resultMap.put("생활",0);
		resultMap.put("IT",0);
		resultMap.put("오피니언",0);
		for(int i=0; i<listMap.size(); i++) {
			st = new StringTokenizer((String) listMap.get(i).get("news_category"));
			while(st.hasMoreTokens()) {
				String category = st.nextToken();
				if(resultMap.containsKey(category)) { // 해당 밸류의 키를 가지고 있다면
					resultMap.put(category, resultMap.get(category)+ Integer.parseInt(String.valueOf(listMap.get(i).get("count"))));
				}
			}
			resultMap.put("전체", resultMap.get("전체")+ Integer.parseInt(String.valueOf(listMap.get(i).get("count"))));
		}
		return resultMap;
	}
}

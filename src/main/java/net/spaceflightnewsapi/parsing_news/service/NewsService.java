package net.spaceflightnewsapi.parsing_news.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.spaceflightnewsapi.parsing_news.model.News;

@Service
public interface NewsService {
	
	public void save(News news);
	public boolean isExist(String newsTitle);
	public List<News> getAllNews();
}

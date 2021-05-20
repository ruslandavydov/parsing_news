package net.spaceflightnewsapi.parsing_news.service;

import java.util.List;

import net.spaceflightnewsapi.parsing_news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spaceflightnewsapi.parsing_news.model.News;

@Service
public class NewsServiceImpl implements NewsService {
	
	@Autowired
    NewsRepository repository;

	@Override
	public void save(News news) {
		repository.save(news);
	}

	@Override
	public boolean isExist(String newsTitle) {
		List<News> allNews = repository.findAll();
		for (News n: allNews) {
			if (n.getTitle().equals(newsTitle)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<News> getAllNews() {
		return repository.findAll();
	}

}

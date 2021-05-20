package net.spaceflightnewsapi.parsing_news;

import java.util.List;

import net.spaceflightnewsapi.parsing_news.model.News;
import net.spaceflightnewsapi.parsing_news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {
	
	@Autowired
    NewsService newsService;
	
	@GetMapping(value = "/news")
	public List<News> getNews() {
		return newsService.getAllNews();
	}
}

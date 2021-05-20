package net.spaceflightnewsapi.parsing_news.job;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.spaceflightnewsapi.parsing_news.model.News;
import net.spaceflightnewsapi.parsing_news.service.NewsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NewsParseTask {
	
	@Autowired
    NewsService newsService;
	
	@Scheduled(fixedDelay = 10000)
	public void parseNews() {
		String url = "https://www.spaceflightnewsapi.net/documentation#/Article/get_api_v2_articles";

		try {
			Document doc = Jsoup.connect(url)
					.userAgent("Opera")
					.timeout(5000)
					.referrer("https://test.spaceflightnewsapi.net/api/v2/articles?_limit=\n" +
							"{articles_limit}&_start={skipped_articles}")
					.get();
			Elements news = doc.getElementsByClass("storyline");
			List<String> blackList = List.of(
					"Putin", "Russia", "Trump", "USA"
			);
			for (Element el: news) {
				String title = el.ownText();
				for (String black : blackList) {
					if (!title.equals(black)) {
						if (!newsService.isExist(title)) {
							News obj = new News();
							obj.setTitle(title);
							newsService.save(obj);
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

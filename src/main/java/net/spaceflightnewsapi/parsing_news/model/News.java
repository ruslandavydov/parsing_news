package net.spaceflightnewsapi.parsing_news.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "ARTICLES")
public class News {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private long id;

	@Column (name ="title")
	private String title;

	@Column(name = "news_site")
	private String newsSite;

	@Column(name = "article")
	private String summary;

	@Column(name = "published_date")
	private SimpleDateFormat publishedAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNewsSite() {
		return newsSite;
	}

	public void setNewsSite(String newsSite) {
		this.newsSite = newsSite;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public SimpleDateFormat getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(SimpleDateFormat publishedAt) {
		this.publishedAt = publishedAt;
	}
}

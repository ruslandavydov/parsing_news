package net.spaceflightnewsapi.parsing_news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.spaceflightnewsapi.parsing_news.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

}

package Url_shortner.url_shortner.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Url_shortner.url_shortner.entity.Url;


@Repository
public interface UrlRepository extends JpaRepository<Url, Long>{

	Url findByOriginalUrl(String originalUrl);

	Url findByShortUrl(String shortUrl);

	List<Url> findByExpiryDateBefore(LocalDateTime now);

	

	

}

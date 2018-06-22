package com.point72.wechat.media;

import java.util.List;

/**
 * 图文
 * 
 * @author Houkm
 *
 *         2017年6月5日
 */
public class News {

	List<Article> articles;

	public News(List<Article> articles) {
		this.articles = articles;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}

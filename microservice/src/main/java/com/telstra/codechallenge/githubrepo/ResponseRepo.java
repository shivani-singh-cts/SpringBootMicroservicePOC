package com.telstra.codechallenge.githubrepo;

public class ResponseRepo {

	private String html_url;
	private Long watchers_count;
	private String language;
	private String description;
	private String name;
	
	public String getHtml_url() {
		return html_url;
	}
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	public Long getWatchers_count() {
		return watchers_count;
	}
	public void setWatchers_count(Long watchers_count) {
		this.watchers_count = watchers_count;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

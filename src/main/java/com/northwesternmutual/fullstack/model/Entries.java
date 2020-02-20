package com.northwesternmutual.fullstack.model;

import com.northwesternmutual.fullstack.model.EntriesForm;

public class Entries {
	private String api;
	private String description;
	private String auth;
	private String https;
	private String cors;
	private String link;
	private String category;
	
	public Entries() { }
	
	public Entries(EntriesForm entriesForm) 
	{ 
		this.api = entriesForm.getApi();
		this.description = entriesForm.getDescription();
		this.auth = entriesForm.getAuth();
		this.https = entriesForm.getHttps();
		this.cors = entriesForm.getCors();
		this.link = entriesForm.getLink();
		this.category = entriesForm.getCategory();
	}

	public Entries(String api, String description, String auth, String https, String cors, String link, String category) 
	{ 
		this.api = api;
		this.description = description;
		this.auth = auth;
		this.https = https;
		this.cors = cors;
		this.link = link;
		this.category = category;
	}
	
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getHttps() {
		return https;
	}
	public void setHttps(String https) {
		this.https = https;
	}
	public String getCors() {
		return cors;
	}
	public void setCors(String cors) {
		this.cors = cors;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}

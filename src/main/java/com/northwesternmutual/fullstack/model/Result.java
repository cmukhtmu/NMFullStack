package com.northwesternmutual.fullstack.model;

public class Result {
	private String count;
	private Entries[] entries;
	
	public Result()
	{
		
	}
	
	public Result(String count, Entries[] entries)
	{
		this.count = count;
		this.entries = entries;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public Entries[] getEntries() {
		return entries;
	}
	public void setEntries(Entries[] entries) {
		this.entries = entries;
	}
}

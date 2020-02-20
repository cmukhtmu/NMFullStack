package com.northwesternmutual.fullstack.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.io.*;
import java.nio.charset.Charset;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;


import org.json.simple.parser.*;
import org.springframework.stereotype.Repository;
import org.json.simple.*;
import com.google.gson.*;

import com.northwesternmutual.fullstack.model.Entries;

@Repository
public class EntriesDAO {
	
	public List<Entries> getAllEntries() 
	{	
		List<Entries> result = new ArrayList<Entries>();
		result = getMockData("AllEntries.json");
		return result;
	}	
	
	public List<Entries> getEntriesByCategory(String category) {

		
		List<Entries> result = new ArrayList<Entries>();
		result = getMockData("BookEntries.json");
		
		return result;
	}
	
	private List<Entries> getMockData(String fileName)
	{
		List<Entries> result = new ArrayList<Entries>();
		try
		{
		
			JSONParser parser = new JSONParser();			
			Object obj = parser.parse(new FileReader(getClass().getClassLoader().getResource(fileName).getFile())); 
			JSONObject jsonObject = (JSONObject) obj;
			
			Object[] data = ((JSONArray)jsonObject.get("entries")).toArray();
			
        	for (int i = 0; i < data.length; i++) 
        	{
        		// adding a try-catch inside for loop so that if an asset initialization fails, the loop doesn't break
        		try
        		{		                	                
	                String API = ((JSONObject)data[i]).get("API").toString();
	                String Description = ((JSONObject)data[i]).get("Description").toString();
	                String Auth = ((JSONObject)data[i]).get("Auth").toString();
	                String HTTPS = ((JSONObject)data[i]).get("HTTPS").toString();
	                String Cors = ((JSONObject)data[i]).get("Cors").toString();
	                String Link = ((JSONObject)data[i]).get("Link").toString();
	                String Category = ((JSONObject)data[i]).get("Category").toString();
	                
	                result.add(new Entries(API, Description, Auth, HTTPS, Cors, Link, Category));	                
        		}
        		catch(Exception exc)
        		{
        			exc.printStackTrace();
        		}
        	}
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		return result;
	}

}

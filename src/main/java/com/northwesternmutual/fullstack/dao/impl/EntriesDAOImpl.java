package com.northwesternmutual.fullstack.dao.impl;


import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.parser.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.json.simple.*;
import com.northwesternmutual.fullstack.dao.EntriesDAO;
import com.northwesternmutual.fullstack.model.Entries;

@Repository
public class EntriesDAOImpl implements EntriesDAO 
{
	@Autowired
	private Environment env;
	
	@Override
	public List<Entries> getAllEntries() 
	{	
		
		List<Entries> result = new ArrayList<Entries>();
		
		try 
		{
			//result = getMockData("AllEntries.json");	
			String baseUrl = env.getProperty("baseUrl");
            URL url = new URL(baseUrl + "entries");//your url i.e fetch data from .
            result = this.callAPI(url);
            
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
        finally {
        	
        }
		
		return result;
	}	
	
	@Override
	public List<Entries> getEntriesByCategory(String category) {
		List<Entries> result = new ArrayList<Entries>();
        try {
        	String baseUrl = env.getProperty("baseUrl");
            URL url = new URL(baseUrl + "entries?category=" + category);//your url i.e fetch data from .
            result = this.callAPI(url);
            
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
        finally {
        	
        }
		
		return result;
	}
	
	private List<Entries> callAPI(URL url)
	{
		List<Entries> result = new ArrayList<Entries>();
		try 
		{
			//result = getMockData("AllEntries.json");            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            result = this.parseRawJSON(br);
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
        finally {
        	
        }
		
		return result;
	}
	
	private List<Entries> parseRawJSON(Reader reader)
	{
		List<Entries> result = new ArrayList<Entries>();
		try
		{		
			JSONParser parser = new JSONParser();			
			Object obj = parser.parse(reader); 
			JSONObject jsonObject = (JSONObject) obj;
			
			Object[] data = ((JSONArray)jsonObject.get("entries")) != null ? ((JSONArray)jsonObject.get("entries")).toArray() : new Object[0];
			
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
	
	private List<Entries> getMockData(String fileName) throws Exception
	{
		return this.parseRawJSON(new FileReader(getClass().getClassLoader().getResource(fileName).getFile()));		
	}
}

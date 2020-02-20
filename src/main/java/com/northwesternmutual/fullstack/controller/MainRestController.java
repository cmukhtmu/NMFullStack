package com.northwesternmutual.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.northwesternmutual.fullstack.dao.EntriesDAO;
import com.northwesternmutual.fullstack.model.Entries;
import com.northwesternmutual.fullstack.model.EntriesForm;

@RestController
public class MainRestController {
	@Autowired
	private EntriesDAO entriesDAO;
	
	@RequestMapping(value="/entries", method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Entries> getAllEntries()
	{
		List<Entries> lstEntries = entriesDAO.getAllEntries();
		return lstEntries;
	}
	@RequestMapping(value="/entries/{category}", method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Entries> getEntriesByCategory(@PathVariable("category") String category)
	{
		List<Entries> lstEntries = entriesDAO.getEntriesByCategory(category);
		return lstEntries;
	}
}

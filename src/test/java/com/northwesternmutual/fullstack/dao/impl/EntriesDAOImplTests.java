package com.northwesternmutual.fullstack.dao.impl;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.Assert;

import com.northwesternmutual.fullstack.dao.EntriesDAO;
import com.northwesternmutual.fullstack.model.Entries;

@SpringBootTest
@ComponentScan ({"com.northwesternmutual.fullstack"})
public class EntriesDAOImplTests {
	
	@Autowired
	private EntriesDAO entriesDAO;
	
	@Test
	public void getAllEntriesTest() {
		
		List<Entries> result = entriesDAO.getAllEntries();
		Assert.notEmpty(result, "All entries should never be empty");
	}
	
	@Test
	public void getEntriesByCategoryTest() {
		
		List<Entries> bookResult = entriesDAO.getEntriesByCategory("Books");
		Assert.notEmpty(bookResult, "Books entries should never be empty");

		List<Entries> animalResult = entriesDAO.getEntriesByCategory("Animals");
		Assert.notEmpty(animalResult, "Animals entries should never be empty");

		List<Entries> fakeResult = entriesDAO.getEntriesByCategory("Fake");
		Assert.isTrue(fakeResult.isEmpty(), "Fake entries should be empty");
	}
}

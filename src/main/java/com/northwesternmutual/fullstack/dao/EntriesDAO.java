package com.northwesternmutual.fullstack.dao;

import java.util.List;
import com.northwesternmutual.fullstack.model.Entries;

public interface EntriesDAO {

	 List<Entries> getAllEntries();
	 List<Entries> getEntriesByCategory(String category);
}

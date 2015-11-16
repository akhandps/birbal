package com.birbalv2.dal;

import java.util.List;

public interface StorageConnector {
	
	public void init();
	
	public <T> T querySingle(String query, String param, Class<T> clazz);

	public <T> List<T> query(String query, String param, Class<T> clazz);
	
	public <T> boolean save(T obj);
}

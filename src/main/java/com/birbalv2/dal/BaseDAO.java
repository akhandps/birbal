package com.birbalv2.dal;

public interface BaseDAO<T> {
	T get(String param);
	void save(T obj);
}

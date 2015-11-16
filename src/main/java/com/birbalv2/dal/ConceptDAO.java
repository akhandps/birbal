package com.birbalv2.dal;

import com.birbalv2.model.Concept;

public class ConceptDAO implements BaseDAO<Concept> {

	StorageConnector connect = new MongoStorageConnector();

	@Override
	public Concept get(String param) {
		String query = "conceptName =";
		Concept concept = connect.querySingle(query, param, Concept.class);
		return concept;
	}

	@Override
	public void save(Concept concept) {
		connect.save(concept);
	}
	
}

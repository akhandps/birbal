package com.birbalv2.dal;

import java.util.Collections;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongoStorageConnector implements StorageConnector {

	private static Datastore datastore = null;

	public void init() {
		if (datastore != null)
			return;

		final Morphia morphia = new Morphia();

		// tell Morphia where to find your classes
		// can be called multiple times with different packages or classes
		morphia.mapPackage("com.birbalv2.model");

		String host = System.getenv("OPENSHIFT_MONGODB_DB_HOST");
		String sport = System.getenv("OPENSHIFT_MONGODB_DB_PORT");
		String db = System.getenv("OPENSHIFT_APP_NAME");
		if (db == null)
			db = "birbalv2";
		String user = System.getenv("OPENSHIFT_MONGODB_DB_USERNAME");
		String password = System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD");
		int port = Integer.decode(sport);

		ServerAddress serverAddress = new ServerAddress(host, port);
		MongoCredential credential = MongoCredential.createCredential(user, db,
				password.toCharArray());
		MongoClient client = new MongoClient(serverAddress,
				Collections.singletonList(credential));
		// create the Datastore connecting to the default port on the local host
		datastore = morphia.createDatastore(client, "birbalv2");
		datastore.ensureIndexes();
	}

	@Override
	public <T> List<T> query(String queryInput, String param, Class<T> clazz) {
		init();
		List<T> output = datastore.createQuery(clazz).filter(queryInput, param)
				.asList();
		return output;
	}

	@Override
	public <T> T querySingle(String queryInput, String param, Class<T> clazz) {
		init();
		T output = datastore.createQuery(clazz).filter(queryInput, param).get();
		return output;
	}

}

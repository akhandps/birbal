package com.birbalv2.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Property;

@Entity("brain")
@Indexes(@Index(fields = @Field("conceptName")))
public class Concept {
	@Id
	private ObjectId id;

	@Property("concept_name")
	private String conceptName;

	@Property("concept_value")
	private String conceptValue;

	public Concept(ObjectId id, String conceptName, String conceptValue) {
		super();
		this.id = id;
		this.conceptName = conceptName;
		this.conceptValue = conceptValue;
	}

	public String getConceptName() {
		return conceptName;
	}

	public void setConceptName(String conceptName) {
		this.conceptName = conceptName;
	}

	public String getConceptValue() {
		return conceptValue;
	}

	public void setConceptValue(String conceptValue) {
		this.conceptValue = conceptValue;
	}
}

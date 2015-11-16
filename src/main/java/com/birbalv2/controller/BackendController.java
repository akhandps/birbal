package com.birbalv2.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.birbalv2.dal.ConceptDAO;
import com.birbalv2.model.Concept;

@Path("/put")
public class BackendController {
	
	@GET
	@Path("/name/{param}")
	@Produces("application/json")
	public String putName(@PathParam("param") String msg) {
		ConceptDAO conceptDAO = new ConceptDAO();
		String out = "success";
		try {
			Concept concept = conceptDAO.get("selfName");
			concept.setConceptValue(msg);
			conceptDAO.save(concept);
		} catch (Exception e) {
			out = e.getMessage();
			e.printStackTrace();
		}
		return out;
	}
}

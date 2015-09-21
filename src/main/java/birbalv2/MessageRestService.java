package birbalv2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/message")
public class MessageRestService {

	@GET
	@Path("/{param}")
    @Produces("application/json")
	public Obj printMessage(@PathParam("param") String msg) {

		String result = "Restful example : " + msg;
		Obj obj = new Obj();
		obj.setId(1);
		obj.setValue(msg);

		return obj;

	}

}
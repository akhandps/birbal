package birbalv2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.birbalv2.responder.JeannieResponder;
import com.birbalv2.responder.Responder;

@Path("/talk")
public class Controller {
	Responder responder = new JeannieResponder();

	@GET
	@Path("/{param}")
	@Produces("application/json")
	public Output talk(@PathParam("param") String msg) {
		String result = "";
		try {
			result = responder.respond(msg, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Output obj = new Output();
		obj.setValue(result);
		return obj;

	}

}
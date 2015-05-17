package lt.ktu.project.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import lt.ktu.projektas.utils.User;
import lt.ktu.projektas.utils.User2;

public class RestRegister implements Register {
	
	private static final String PERSON_URL = "http://84.55.7.191:8080/KtuFormBackend/user";
	
	private WebTarget target;
	
	public RestRegister(Client client){
		target = client.target(PERSON_URL);
	}
	
	@Override
	public String registerUser(User2 person){
		return InvocationWrapper.invokePost(target, "", person, String.class);
	}
	
	@Override
	public String getUser(String id){
		return InvocationWrapper.invokeGet(target, "" + id, String.class);
	}
	
}

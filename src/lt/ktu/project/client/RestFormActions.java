package lt.ktu.project.client;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import lt.ktu.projektas.utils.Form;
import lt.ktu.projektas.utils.User2Container;

public class RestFormActions implements FormActions{
	
	private static final String FORMS_URL = "http://84.55.7.191:8080/KtuFormBackend/forms";
	
	private WebTarget target;
	
	public RestFormActions(Client client){
		target = client.target(FORMS_URL);
	}
	
	@Override
	public Form registerForm(Form form){
		return InvocationWrapper.invokePost(target, "", form, Form.class);
	}
	
	@Override
	public User2Container getForms(String id){
		ArrayList<Form> forms;
		return InvocationWrapper.invokeGet(target, "" + id, User2Container.class);
	}
	
	@Override
	public String getJsonHello() {
		return InvocationWrapper.invokeGet(null, "",String.class, MediaType.APPLICATION_JSON_TYPE);
	}
}

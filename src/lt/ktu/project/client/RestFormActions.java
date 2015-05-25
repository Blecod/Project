package lt.ktu.project.client;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

//import lt.ktu.projektas.utils.Form;
import lt.ktu.projektas.TESTmaterial.Form;
import lt.ktu.projektas.utils.User2Container;

public class RestFormActions implements FormActions{
	
	private static final String FORMS_URL = "http://84.55.18.74:8080/KtuFormBackend";
	
	private WebTarget target;
	
	public RestFormActions(Client client){
		target = client.target(FORMS_URL);
	}
	
	@Override
	public String registerForm(Form form){
		return InvocationWrapper.invokePost(target, "", form, String.class);
	}
	
	@Override
	public User2Container getForms(String id){
		return InvocationWrapper.invokeGet(target, "", User2Container.class);
	}
	
	@Override
	public String putForm(Form form, String id){
		return InvocationWrapper.invokePut(target, "" + id, form, String.class);
	}
	
	@Override
	public String deleteForm(String id){
		return InvocationWrapper.invokeDelete(target, "" + id, String.class);
		
	}
	
}

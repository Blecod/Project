package lt.ktu.project.client;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;


import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;



import lt.ktu.projektas.LoadingGUI;
//import lt.ktu.projektas.utils.Form;
import lt.ktu.projektas.TESTmaterial.Form;
import lt.ktu.projektas.utils.User;
import lt.ktu.projektas.utils.User;
import lt.ktu.projektas.utils.User2Container;

public final class ServerCommunication {
	
	public static Register usr;
	public static FormActions form;
	public static User currentUser;
	public static Client client = ClientBuilder.newClient().register(new Authenticator("Anonymous", ""));
	
	private static void open(){
		client = ClientBuilder.newClient().register(new Authenticator("Anonymous", ""));
		usr = new RestRegister(client);
		form = new RestFormActions(client);
	}
	
	public static void open(String user, String pass){
		client = ClientBuilder.newClient().register(new Authenticator(user, pass));
		usr = new RestRegister(client);
		form = new RestFormActions(client);
	}
	
	public static void close() {
		client.close();
	}
	
	public static void registerUser(User user) throws BadRequestException{ //Priregistruoti naujà vartotojà
		
					String url;
					final String URL = "http://http://84.55.16.5:8080/KtuFormBackend/user";
					WebTarget target = client.target(URL);
					url = usr.registerUser(user); 
					System.out.println(url.toString());
					
	}
	
	public static void LogInUser(String userID, String Pass) throws BadRequestException{

					// ;c
			//		String CurrentUser = currentUser.getUname();
				//	System.out.println("Current User name: " + CurrentUser);
					String url;
					url = usr.getUser(userID);
					
//					System.out.println(url.toString());
//					currentUser.setUname(userID);
//					System.out.println("Updated User name: " + CurrentUser);
				//	currentUser.setName(url);
					//client.property("Authorization", new Authenticator(userID, Pass));
					//client = ClientBuilder.newClient().register(new Authenticator(userID, Pass));
					//client.register(new Authenticator(userID, Pass));
					
				//	System.out.println("A'ight");
		
	}

	public static User2Container getForms(String url) throws BadRequestException{
		User2Container con = new User2Container(null);

					User2Container print;
					con = form.getForms(url);
					System.out.println("MMMMM");
					
			return con; 	
	}
	
	public static void PostForm(Form newForm) throws BadRequestException{
					String id;
					//newForm.setAuthor(currentUser.getName());
					id = form.registerForm(newForm);
					System.out.println("Formos ID: " + id);

	}
	
	public static void PutForm(Form newForm, String id) throws BadRequestException{

					String idd;
					//newForm.setAuthor(currentUser.getName());
					idd = form.putForm(newForm, id);
					System.out.println("Formos ID: " + idd);
				
	}
	
	public static void DeleteUser(String UserID) throws BadRequestException{
					String url;
					url = usr.deleteUser(UserID);
					System.out.println(url.toString());
	}
	
	public static void deleteForm(String id) throws BadRequestException{

					String url;
					url = form.deleteForm(id);
					System.out.println(url.toString());

	}	
	
}

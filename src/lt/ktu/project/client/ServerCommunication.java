package lt.ktu.project.client;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;






import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;




import lt.ktu.projektas.LoadingGUI;
import lt.ktu.projektas.utils.Form;
import lt.ktu.projektas.utils.User;
import lt.ktu.projektas.utils.User2;
import lt.ktu.projektas.utils.User2Container;


public class ServerCommunication {
	
	public static Register usr;
	public static FormActions form;
	//static Client client;
	//client = ClientBuilder.newClient().register(new Authenticator("Anonymous", ""));
	
	
	//HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("Anonymous", "");
	//client = ClientBuilder.newClient();
	public static void BootUp(){
		Client client;
		client = ClientBuilder.newClient().register(new Authenticator("Anonymous", ""));
		usr = new RestRegister(client);
		form = new RestFormActions(client);
	}
	
	
	
	public static void registerUser(User2 user){ //Priregistruoti naujà vartotojà
		//Register usr;
		Client client;
		client = ClientBuilder.newClient();
		//client = ClientBuilder.newClient().register(new Authenticator("Anonymous", ""));
		usr = new RestRegister(client);
		
		Runnable run = new Runnable() {
			@Override
			public void run() {
				
				try {
					String url;
					url = usr.registerUser(user); 
					System.out.println(url.toString());
			  } catch (InternalServerErrorException e) {
				  
				  System.out.println(e.getResponse().getEntity());
		          ByteArrayInputStream stream =(ByteArrayInputStream) e.getResponse().getEntity();
		          int n = stream.available();
		          byte[] bytes = new byte[n];
		          stream.read(bytes, 0, n);
		          String s = new String(bytes, StandardCharsets.UTF_8);
		          System.out.println(s);
				  
			  }
				
				
			}
		};
		LoadingGUI.show(run); 		
		client.close();
	}
	
	public static void LogInUser(String userID, String Pass){
		//Register usr;
		
		Client client;
		client = ClientBuilder.newClient().register(new Authenticator(userID, Pass));
		usr = new RestRegister(client);
		form = new RestFormActions(client);
		
		Runnable run = new Runnable() {
			@Override
			public void run() {
				
				try {
					
					String url;
					url = usr.getUser(userID);
					System.out.println(url.toString());
					
				}	catch (BadRequestException e) {
					  
					  System.out.println(e.getResponse().getEntity());
			          ByteArrayInputStream stream =(ByteArrayInputStream) e.getResponse().getEntity();
			          int n = stream.available();
			          byte[] bytes = new byte[n];
			          stream.read(bytes, 0, n);
			          String s = new String(bytes, StandardCharsets.UTF_8);
			          System.out.println(s);
					  
				  }
					
					
				}
			};
			LoadingGUI.show(run); 		
			//client.close();
		
	}

	public static User2Container getForms(String url){
		User2Container con = new User2Container(null);
		//Runnable run = new Runnable() {
		//	@Override
			//public void run() {
				try {
					User2Container print;
					con = form.getForms(url);
					System.out.println(con.toString());
					} catch (BadRequestException e) {
						  
						  System.out.println(e.getResponse().getEntity());
				          ByteArrayInputStream stream =(ByteArrayInputStream) e.getResponse().getEntity();
				          int n = stream.available();
				          byte[] bytes = new byte[n];
				          stream.read(bytes, 0, n);
				          String s = new String(bytes, StandardCharsets.UTF_8);
				          System.out.println(s);
						  
					 }
					 	
						
			//	}
			//};
			//LoadingGUI.show(run);
			return con; 	
	}
	
	
}

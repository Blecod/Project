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


public class ServerCommunication {
	
	public static Register usr;
	public static FormActions form;
	public static User currentUser;
	public static Client client;
	//client = ClientBuilder.newClient().register(new Authenticator("Anonymous", ""));
	
	public ServerCommunication(){
		//currentUser.setUname("Anonymous");
		client = ClientBuilder.newClient().register(new Authenticator("Anonymous", ""));
		usr = new RestRegister(client);
		form = new RestFormActions(client);
	}
	
	public ServerCommunication(String user, String pass){
		client = ClientBuilder.newClient().register(new Authenticator(user, pass));
		usr = new RestRegister(client);
		form = new RestFormActions(client);
	}
	
	private static void close() {
		client.close();
	}
	
	public static void registerUser(User user){ //Priregistruoti naujà vartotojà
		
		Runnable run = new Runnable() {
			@Override
			public void run() {
				
				try {
					String url;
					final String URL = "http://http://84.55.16.5:8080/KtuFormBackend/user";
					WebTarget target = client.target(URL);
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
		//client.close();
	}
	
	public static void LogInUser(String userID, String Pass){
		
		Runnable run = new Runnable() {
			@Override
			public void run() {
				
				try {
					// ;c
					String CurrentUser = currentUser.getUname();
					System.out.println("Current User name: " + CurrentUser);
//					String url;
//					url = usr.getUser(userID);
//					System.out.println(url.toString());
//					currentUser.setUname(userID);
//					System.out.println("Updated User name: " + CurrentUser);
				//	currentUser.setName(url);
					//client.property("Authorization", new Authenticator(userID, Pass));
					//client = ClientBuilder.newClient().register(new Authenticator(userID, Pass));
					//client.register(new Authenticator(userID, Pass));
					
					System.out.println("A'ight");
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
	
	public static void PostForm(Form newForm){
//		Runnable run = new Runnable() {
//			@Override
//			public void run() {
//				
				try {
					String id;
					//newForm.setAuthor(currentUser.getName());
					id = form.registerForm(newForm);
					System.out.println("Formos ID: " + id);
				} catch (InternalServerErrorException e) {
					  
					  System.out.println(e.getResponse().getEntity());
			          ByteArrayInputStream stream =(ByteArrayInputStream) e.getResponse().getEntity();
			          int n = stream.available();
			          byte[] bytes = new byte[n];
			          stream.read(bytes, 0, n);
			          String s = new String(bytes, StandardCharsets.UTF_8);
			          System.out.println(s);
					  
				  }
//			}
//		};
//		LoadingGUI.show(run);
	}
	
	public static void PutForm(Form newForm, String id){
//		Runnable run = new Runnable() {
//			@Override
//			public void run() {
//				
				try {
					String idd;
					//newForm.setAuthor(currentUser.getName());
					idd = form.putForm(newForm, id);
					System.out.println("Formos ID: " + idd);
				} catch (InternalServerErrorException e) {
					  
					  System.out.println(e.getResponse().getEntity());
			          ByteArrayInputStream stream =(ByteArrayInputStream) e.getResponse().getEntity();
			          int n = stream.available();
			          byte[] bytes = new byte[n];
			          stream.read(bytes, 0, n);
			          String s = new String(bytes, StandardCharsets.UTF_8);
			          System.out.println(s);
					  
				  }
//			}
//		};
//		LoadingGUI.show(run);
	}
}

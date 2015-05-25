package lt.ktu.project.client;

import javax.ws.rs.client.WebTarget;

import lt.ktu.projektas.utils.User;
import lt.ktu.projektas.utils.User;

public interface Register {
	String registerUser(User usr);
	String getUser(String id);
	String deleteUser(String id);
}

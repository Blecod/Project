package lt.ktu.project.client;

import java.util.ArrayList;

//import lt.ktu.projektas.utils.Form;
import lt.ktu.projektas.TESTmaterial.Form;
import lt.ktu.projektas.utils.User2Container;

public interface FormActions {
	String registerForm(Form form);
	String putForm(Form form, String id);
	User2Container getForms(String id);
	String deleteForm(String id);
	//Strin
}

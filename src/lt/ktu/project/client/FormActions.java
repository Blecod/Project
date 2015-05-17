package lt.ktu.project.client;

import java.util.ArrayList;

import lt.ktu.projektas.utils.Form;
import lt.ktu.projektas.utils.User2Container;

public interface FormActions {
	Form registerForm(Form form);
	User2Container getForms(String id);
	String getJsonHello();
}

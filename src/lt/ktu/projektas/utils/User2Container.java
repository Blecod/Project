package lt.ktu.projektas.utils;

import java.util.ArrayList;

public class User2Container {
	private ArrayList<Form> forms;
	
	public User2Container(ArrayList<Form> form)
	{
		this.forms = form;
	}

	public ArrayList<Form> getForms() {
		return forms;
	}

	public void setForms(ArrayList<Form> forms) {
		this.forms = forms;
	}
}

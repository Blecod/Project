package lt.ktu.projektas.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User2 {
	private String uname;
	private String pass;
	
	@JsonProperty("isCompany")
	private boolean isCompany;
	private String surname;
	private String name;
	private String company;
	//private String testyField;
	
	public User2(String uName, String Pass, String Name, String nik, String Company){
		this.uname = uName;
		this.pass = Pass;
		this.name = Name;
		this.surname = nik;
		this.isCompany = false;
		this.company = Company;
		//this.testyField = "testyField";
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setNick(String nick) {
		this.surname = nick;
	}
	public boolean isCompany() {
		return isCompany;
	}
	public void setCompany(boolean isCompany) {
		this.isCompany = isCompany;
	}
	public void setCompany(String compan){
		this.company = compan;
	}
	public String getCompany(){
		return company;
	}
	
	//public void settesty(String compan){
	//	this.testyField = compan;
	//}
	//public String gettesty(){
	//	return testyField;
	//}
}

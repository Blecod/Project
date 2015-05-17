/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lt.ktu.projektas.utils;

/**
 *
 * @author Domas
 */
public class User {
    private final String firstName, secondName, email;
    private String password;
    private boolean company;
    
    public User(String firstName, String secondName, String email){
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = null;
        this.company = false;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getSecondName(){
        return secondName;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    
    public boolean getCompany(){
    	return company;
    }
    
    
    @Override
	public String toString() {
		return 
			  "{ uname : " + email + ", \n" +
			  "pass : " + password + ", \n" + 
			  "name : " + firstName + ", \n" +
			  "surname : " + secondName + ", \n" +
			  "isCompany : " + company + ", \n }";

	}
}

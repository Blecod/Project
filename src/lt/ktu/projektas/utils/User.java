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
    public User(String firstName, String secondName, String email){
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = null;
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
}

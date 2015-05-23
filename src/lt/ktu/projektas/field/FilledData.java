/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.ktu.projektas.field;
import java.util.ArrayList;
import java.util.Arrays;


import java.util.Random;

import javafx.beans.property.SimpleStringProperty;
import lt.ktu.projektas.utils.User;


public class FilledData<E>{

	private final User user;
	private final SimpleStringProperty date;
	private final SimpleStringProperty userFullName;
	private final E[] data;
    public FilledData(User user, String date, E[] data){
        this.user = user;
        this.date = new SimpleStringProperty(date);
        this.userFullName = new SimpleStringProperty(user.getFirstName()+" "+user.getSecondName()+",\n"+user.getEmail());
        this.data = data;
    }
    public E[] getData(){
    	return data;
    }
    public String getStringAt(int id){
    	return data[id].toString();
    }
    public String getDate(){
        return date.get();
    }
    public String getUserFullName(){
    	return userFullName.get();
    }
    public User getUser(){
        return user;
    }
 
}

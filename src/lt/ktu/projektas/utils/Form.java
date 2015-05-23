
package lt.ktu.projektas.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lt.ktu.projektas.field.Field;
import lt.ktu.projektas.field.FilledData;

/**
 *
 * @author Domas
 */
public class Form {
    private String title, date;
    private User user;
    private FilledData<Object>[] data;
    private Field[] columns;
    private FormType type;
    public Form(FormType type, String name, User user, String date){
    	this.type = type;
        this.title = name;
        this.user = user;
        this.date = date;
        
    }
    public FormType getType(){
    	return type;
    }
    public String getTitle(){
        return title;
    }
    public User getUser(){
        return user;
    }
    public String getDate(){
        return date;
    }
    public void setFields(Field[] columns){
        this.columns = columns;
    }
    public Field[] getFields(){
        return columns;
    }
    public void setData(FilledData<Object>[] data){
        this.data = data;
    }
    public FilledData<Object>[] getData(){
        return data;
    }
    public ObservableList<FilledData<Object>> getObservableList(){
    	
    	ObservableList<FilledData<Object>> list = FXCollections.observableArrayList();
    	for(FilledData<Object> e:data)
    		list.add(e);
    	return list;
    	
    }
    
}

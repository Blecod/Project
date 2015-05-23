/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lt.ktu.projektas.field;
import java.awt.Component;

import javafx.scene.control.*;

import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public enum FieldType {
    INTEGER("integer"),
    STRING("string"),
    EMAIL("email"),
    ONE_CHOICE("one-choice"),
    MULTI_CHOICE("multi-choice");
    private String title;
    private FieldType(String title){
    	this.title = title;
    }
    public static FieldType[] getAllTypes(){
    	return new FieldType[]{INTEGER, STRING, EMAIL, ONE_CHOICE, MULTI_CHOICE};
    }
    public String toString(){
    	return title;
    }
}

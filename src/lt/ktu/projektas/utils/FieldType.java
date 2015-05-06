/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lt.ktu.projektas.utils;
import java.awt.Component;

import javafx.scene.control.*;

import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Domas
 */
public enum FieldType {
    TEXTFIELD("Text field"),
    TEXTAREA("Text area"),
    INTEGER("Integer field"),
    DOUBLE("Double field"),
    BOOLEAN("Checkbox"),
    COMBOBOX("Combobox");
    private String title;
    private FieldType(String title){
    	this.title = title;
    }
    public static FieldType[] getAllTypes(){
    	return new FieldType[]{TEXTFIELD, TEXTAREA, INTEGER, DOUBLE, BOOLEAN, COMBOBOX};
    }
    public String toString(){
    	return title;
    }
}

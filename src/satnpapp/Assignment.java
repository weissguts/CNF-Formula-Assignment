/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satnpapp;

import java.util.HashMap;

/**
 *
 * @author Daniel Hernandez
 */
public class Assignment {
    static HashMap<Literal, Boolean> assignments = new HashMap<Literal, Boolean>(); 

    public void setValue(String string, boolean var) {
        assignments.put(new Literal(string, var), var);
    }

    public static void getValue(String string) {
        assignments.get(new Literal(string, false));
    }
    
    public static String[] literals() {
        return null;
    }
    
    
}

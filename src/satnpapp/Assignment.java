/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satnpapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static String[] literalsA() { 
       
        List<String> newLiteralsList = new ArrayList<String>();
        String[] newLiteralArray = null;
        
        
        for(Literal entry : assignments.keySet()) {
            String key = entry.getName();
            newLiteralsList.add(key);
            System.out.println("Test 8!!!");
        }
       
        for (int i = 0; i <newLiteralsList.size(); i++) {            
            newLiteralArray = newLiteralsList.toArray(new String[i]);            
            i++;
        }
        
        return newLiteralArray;

    }

}

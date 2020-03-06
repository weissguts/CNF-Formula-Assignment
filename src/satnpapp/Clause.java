/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satnpapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Daniel Hernandez
 */
public class Clause {

    static List<Literal> literals = new ArrayList<>();
    
    public static boolean verify(Assignment assignment) {
        return false;
    }
    
    public static String[] literals() {
        String[] literalNames = new String[literals.size()];
        int i = 0;
        for(Literal literal: literals){
          
            if(!Arrays.asList(literalNames).contains(literal.getName())){
                literalNames[i++]=literal.getName();            
            }
        }
        return literalNames;
    }

    public static void addLiteral(Literal literal) {
        literals.add(literal);
               
    }
    
    
    
//    static String[] literals;
//    
//    public static boolean verify(Assignment assignment) {
//        return false;
//    }
//    
//    public static String[] literals() {
//        return literals;
//    }
//
//    public static void addLiteral(String string) {
//        String[] newLiterals = new String[literals.length + 1];
//        for(int i = 0; i < literals.length; i++) {
//            newLiterals[i] = literals[i];          
//        }
//        newLiterals[literals.length] = string;
//        literals = newLiterals;
//               
//    }

}

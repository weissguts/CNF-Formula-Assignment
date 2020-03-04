/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satnpapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Hernandez
 */
public class CnfFormula {
    
    static List<Clause> clauses = new ArrayList<>();
    
    public static String[] literals() {
        return null;
    }
    
    public boolean verify(Assignment assignment) {
        return false;
    }

    public static void addClause(Clause clause) {
        clauses.add(clause);
               
    }
}

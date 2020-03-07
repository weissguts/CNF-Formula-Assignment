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

//    This method does not work. For some reason when I set my view to visibile, 
//    it increases size of hash map. This making this method not able to check 
//    1 for 1. 
    public boolean verify(Assignment assignment) {
//            Return true, if the truth assignments for the variables in the Assignment
//            saisfy this formula/clause.
//        for (int i = 0; i <= this.clauses.size(); i++) {
//
//            if (assignment.assignments.get(i).equals(this.clauses.get(i).literals.get(i).isIsNegated()) ){
//                return true;
//            } else {
//                return false;
//            }
//        }
        return false;

    }

    public static void addClause(Clause clause) {
        clauses.add(clause);

    }
}

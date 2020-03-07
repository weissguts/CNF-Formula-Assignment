/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satnpapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *  This assignment focuses on conjunctive normal form formulas (cnf-formula) and satisfiability.
 * @author Daniel Hernandez
 */
public class SatNpApp {

    static AssignmentView view;
    static BufferedReader bufferedReader = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//  prompts the user for the location of a file to load a cnf-formula (use JFileChooser)
        view = new AssignmentView();
//        System.out.println("Test 1 Main!!!");
        chooseExprLocation();
//        System.out.println("Test 2 Main!!!");
//  reads a cnf-formula from the file creating a CnfFormula object (see file-format below),

        try {
            CnfFormula formula = loadCnfFormula();
//            System.out.println("Test 3 Main !!!");

//  prompt the user for a variable assignment (see AssignmentView below),
            do {
                int i = 0;
                int j = formula.clauses.size();
                Assignment assignment = new Assignment();

                while (!(i >= j)) {
                    assignment.setValue(formula.clauses.get(i).literals.get(i).getName(), formula.clauses.get(i).literals.get(i).isIsNegated());
                    i++;                    
                }                 
//                    System.out.println("Test 5 Main!!!");
                    view.setModel(assignment);
//                    System.out.println("Test 6 Main!!!");
                    view.setVisible(true);                //***For some reason 
                    // .setVisibile is adding to my assignments hash map. This is causing issues when verifying.
//                    System.out.println("Test 9 Main!!!");
                    assignment = view.getModel(); //make sure assignment is right
//                    System.out.println("Test 10 Main!!!");
//  verifies and displays whether the user’s assignment satisfies the cnf-formula,                
                if (formula.verify(assignment)) {
                    JOptionPane.showMessageDialog(null, "Satisfied");
                } else {
                    JOptionPane.showMessageDialog(null, "Not Satisfied");
                }               
//              ****Exiting here since program is not complete, and will run
//              ****infinitely. 
                System.exit(0);
//  determines whether the cnf-formula is satisfiable and if so, output the assignment,
                isSatisfiable(formula);
            } while (trueFalsePrompt("Test another input string?"));
        } catch (Exception e) {
        }

    }

//  as Java comments give the Big-O analysis of the verify and isSatisfiable methods,
//  as a separate file, submit the cnf-formula file you “unit” tested on.       
    static boolean verify(Assignment assignment) {        
        return false;
    }

    static Assignment satisfiable() {
        return null;
    }

    private static void chooseExprLocation() throws FileNotFoundException {
        //read file
        FileChooser fcs = new FileChooser();
        bufferedReader = new BufferedReader(new FileReader(fcs.Chooser()));

    }

    private static CnfFormula loadCnfFormula() throws IOException {
        CnfFormula loadedFormula = new CnfFormula();

        //read line
        String firstLine = bufferedReader.readLine();
        if (firstLine != null) {
            String[] clauseStrings = firstLine.split(" \\^ ");
            String[] disjunctionStrings;
            String[] literalStrings;
            for (String clauseString : clauseStrings) {
                Clause clause = new Clause();
                disjunctionStrings = clauseString.split(" v ");

                for (String disjunctionString : disjunctionStrings) {
                    boolean isNegated = false;

                    if (disjunctionString.charAt(0) == 'n') {
                        isNegated = true;
                        disjunctionString = disjunctionString.substring(0, 3);
                    }
                    if (disjunctionString.charAt(0) == '(') {
                        disjunctionString = disjunctionString.substring(1);
                    }
                    if (disjunctionString.endsWith(")")) {
                        disjunctionString = disjunctionString.substring(0, 2);
                    }

                    Literal literal = new Literal(disjunctionString, isNegated);
                    clause.addLiteral(literal);

                    loadedFormula.addClause(clause);
//                    System.out.println("Test 4!!!");

                }

            }
        }
        return loadedFormula;

    }

    private static void isSatisfiable(CnfFormula formula) {
        //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static boolean trueFalsePrompt(String test_another_input_string) {
        //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

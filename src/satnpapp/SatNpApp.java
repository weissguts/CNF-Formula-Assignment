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
 *
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
        System.out.println("Test 1!!!");
        chooseExprLocation();
        System.out.println("Test 2!!!");
//  reads a cnf-formula from the file creating a CnfFormula object (see file-format below),

        try {
            CnfFormula formula = loadCnfFormula();
            System.out.println("Test 3!!!");

//  prompt the user for a variable assignment (see AssignmentView below),
            do {
                Assignment assignment = new Assignment();

                for (int i = 0; i < formula.clauses.size(); i++) {
                    assignment.setValue(formula.clauses.get(i).literals.get(i).getName(), formula.clauses.get(i).literals.get(i).isIsNegated());
                }

                System.out.println("Test 5!!!");
                view.setModel(assignment);
                System.out.println("Test 6!!!");
                view.setVisible(true);

                assignment = view.getModel(); //make sure assignment is right

//  verifies and displays whether the user’s assignment satisfies the cnf-formula,
                if (formula.verify(assignment)) {
                    JOptionPane.showMessageDialog(null, "Satisfied");
                } else {
                    JOptionPane.showMessageDialog(null, "Not Satisfied");
                }
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
                        disjunctionString = disjunctionString.substring(1);
                    }
                    if (disjunctionString.charAt(0) == '(') {
                        disjunctionString = disjunctionString.substring(1);
                    }
                    if (disjunctionString.endsWith(")")) {
                        disjunctionString = disjunctionString.substring(0, 1);
                    }

                    Literal literal = new Literal(disjunctionString, isNegated);

                    clause.addLiteral(literal);

                    loadedFormula.addClause(clause);
                    System.out.println("Test 4!!!");
//                    clause.addLiteral(disjunctionString);

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

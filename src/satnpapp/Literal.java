/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satnpapp;

/**
 *
 * @author Daniel Hernandez
 */
public class Literal {
    
    private String name;
    private boolean isNegated;

    public Literal(String name, boolean isNegated) {
        this.name = name;
        this.isNegated = isNegated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsNegated() {
        return isNegated;
    }

    public void setIsNegated(boolean isNegated) {
        this.isNegated = isNegated;
    }
    
    
    
}

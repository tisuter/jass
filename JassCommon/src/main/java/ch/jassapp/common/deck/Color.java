/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jassapp.common.deck;

/**
 *
 * @author tisuter
 */
public enum Color {
    Rose("Rose"), Schelle("Schelle"), Eichle("Eichle"), Schilte("Schilte");
    
    private final String name;

    private Color(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;        
    }
    
}

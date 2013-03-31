/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jassapp.common.deck;

/**
 *
 * @author tisuter
 */
public enum Type {
    
    Sechsi("Sechsi"),
    Sibni("Sibni"),
    Achti("Achti"),
    Nueni("Nueni"),
    Banner("Banner"),
    Under("Under"),
    Ober("Ober"),
    Koenig("Koenig"),
    Ass("Ass");
    
    private final String name;

    private Type(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }    
}

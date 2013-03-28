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
    
    Sechsi("Sechsi", 0, 0, 0, 11, 0),
    Sibni("Sibni", 0, 0, 0, 0, 1),
    Achti("Achti", 0, 0, 8, 8, 2),
    Nueni("Nueni", 0, 14, 0, 0, 3),
    Banner("Banner", 10, 10, 10, 10, 4),
    Under("Under", 2, 20, 2, 2, 5),
    Ober("Ober", 3, 3, 3, 3, 6),
    Koenig("Koenig", 4, 4, 4, 4, 7),
    Ass("Ass", 11, 11, 11, 0, 8);
    
    private final String name;
    private final int nichtTrumpfValue;
    private final int trumpfValue;
    private final int obeValue;
    private final int undeValue;
    private final int order;

    private Type(String name, int nichtTrumpfValue, int trumpfValue, int obeValue, int undeValue, int order) {
        this.name = name;
        this.nichtTrumpfValue = nichtTrumpfValue;
        this.trumpfValue = trumpfValue;
        this.obeValue = obeValue;
        this.undeValue = undeValue;
        this.order = order;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getNichtTrumpfValue() {
        return nichtTrumpfValue;
    }

    public int getTrumpfValue() {
        return trumpfValue;
    }

    public int getObeValue() {
        return obeValue;
    }

    public int getUndeValue() {
        return undeValue;
    }

    public int getOrder() {
        return order;
    }
    
}

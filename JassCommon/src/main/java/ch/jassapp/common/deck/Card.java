/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jassapp.common.deck;

/**
 *
 * @author tisuter
 */
public class Card implements Comparable<Card> {

    private final Color color;
    private final Type type;

    private int value;
    private int order;
    
    public Card(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return color.toString() + " " + type.toString();
    }

    public int compareTo(Card o) {
        int sameColor = color.compareTo(o.color);
        if (sameColor != 0) {
            return sameColor;
        }

        return type.compareTo(o.type);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.color != null ? this.color.hashCode() : 0);
        hash = 11 * hash + (this.type != null ? this.type.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.color != other.color) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }
    
}

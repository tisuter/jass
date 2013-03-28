/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.jassapp.common.gameMode;

import ch.jassapp.common.deck.Card;
import ch.jassapp.common.deck.Color;
import ch.jassapp.common.deck.Type;


public class TrumpfCardComparator extends CardComparator {
    
    private ObeCardComparator obeCardComparator = new ObeCardComparator();
    private Color trumpfColor;

    public void setTrumpfColor(Color trumpfColor) {
        this.trumpfColor = trumpfColor;
    }

    @Override
    public void setPlayedCardColor(Color playedCardColor) {
        super.setPlayedCardColor(playedCardColor);
        obeCardComparator.setPlayedCardColor(playedCardColor);
    }           
    
    public int compare(Card o1, Card o2) {
        if(o1.getColor() == trumpfColor) {
            if(o2.getColor() == trumpfColor ) {
                //Beides Trumpf
                if(o1.getType() == Type.Under) {
                    return -1;
                }
                
                if(o2.getType() == Type.Under) {
                    return 1;
                }
                
                if(o1.getType() == Type.Nueni) {
                    return -1;
                }
                
                if(o2.getType() == Type.Nueni) {
                    return 1;
                } 
                
                return o2.getType().getOrder() - o1.getType().getOrder();
            } else {
                //nur o1 Trumpf
                return -1;
            }
        } else {
            if(o2.getColor() == trumpfColor ) {
                //nur o2 Trumpf
                return 1;
            } else {
                //beides kein Trumpf...
                return obeCardComparator.compare(o1, o2);
            } 
        }
    }
}

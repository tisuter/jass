/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.jassapp.common.gameMode;

import ch.jassapp.common.deck.Card;


public class ObeCardComparator extends CardComparator {

    
    
    public int compare(Card o1, Card o2) {
        if(o1.getColor() == o2.getColor()) {
            return o2.getType().getOrder() - o1.getType().getOrder();
        }
        
        if(o1.getColor() == playedCardColor) {
            return -1;
        }
        
        if(o2.getColor() == playedCardColor) {
            return 1;
        }
        
        return o2.getType().getOrder() - o1.getType().getOrder();
    }
}

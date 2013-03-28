/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.jassapp.common.gameMode;

import ch.jassapp.common.deck.Card;


public class UndeCardComparator extends CardComparator {

    public int compare(Card o1, Card o2) {
        if(o1.getColor() == o2.getColor()) {
            return o1.getType().getOrder() - o2.getType().getOrder();
        }
        
        if(o2.getColor() == playedCardColor) {
            return 1;
        }
        
        if(o1.getColor() == playedCardColor) {
            return -1;
        }
        
        return o1.getType().getOrder() - o2.getType().getOrder();
    }
}

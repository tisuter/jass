/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.jassapp.common.gameMode;

import ch.jassapp.common.deck.Card;
import ch.jassapp.common.deck.Color;
import java.util.Comparator;

/**
 *
 * @author tisuter
 */
public abstract class CardComparator implements Comparator<Card> {
    
    protected Color playedCardColor;

    public void setPlayedCardColor(Color playedCardColor) {
        this.playedCardColor = playedCardColor;
    }
}

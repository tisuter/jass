/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jassapp.common.jasstype;

import ch.jassapp.common.deck.Card;
import ch.jassapp.common.deck.Color;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author christoph
 */
public abstract class AbstractJassType implements Comparator<Card>{
    
    protected Color playedCardColor;
            
    public AbstractJassType()  {

    }

    public void initDeck(List<Card> deck) {
        setCardValue(deck);
        setCardOrder(deck);
    }
    
    public void setPlayedCardColor(Color playedCardColor) {
        this.playedCardColor = playedCardColor;
    }
  
    protected abstract void setCardValue(List<Card> deck);
    protected abstract void setCardOrder(List<Card> deck);
}

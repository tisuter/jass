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
    
    /**
     * Checks if the Card can be played...
     * 
     * 
     * @param cardToPlay
     * @param alreadyPlayedCards
     * @param cardsFromPlayer
     * @return ErrorCode:
     * 1. You have to use the correct Color (Exceptions: You are out of this Color, Trumpf)
     * 2. Not Untertrumpfen (Exceptions: You have no other choice)
     * 3. You don not have this card in your 'playerCards'
     */
    public abstract int isCardAllowed(Card cardToPlay, List<Card> alreadyPlayedCards, List<Card> cardsFromPlayer);
    
    @Override
    public abstract String toString();
}

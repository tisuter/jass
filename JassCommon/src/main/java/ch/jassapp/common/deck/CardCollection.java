/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.jassapp.common.deck;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tisuter
 */
public class CardCollection {
    private List<Card> collectedCards = new ArrayList<Card>();

    public void clear() {
        collectedCards.clear();
    }
    
    public void add(Card card) {
        collectedCards.add(card);
    }
    
    public void addAll(List<Card> cards) {
        collectedCards.addAll(cards);
    }
    
    public int CountPoints() {
        int points = 0;
        for(Card card: collectedCards) {
            points += card.getValue();
        }
        return points;
    }

    public List<Card> getCards() {
        return collectedCards;
    }
    
    
}

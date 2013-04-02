/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jassapp.common.jasstype;

import ch.jassapp.common.deck.Card;
import ch.jassapp.common.deck.Color;
import static ch.jassapp.common.deck.Type.Achti;
import static ch.jassapp.common.deck.Type.Ass;
import static ch.jassapp.common.deck.Type.Banner;
import static ch.jassapp.common.deck.Type.Koenig;
import static ch.jassapp.common.deck.Type.Nueni;
import static ch.jassapp.common.deck.Type.Ober;
import static ch.jassapp.common.deck.Type.Sechsi;
import static ch.jassapp.common.deck.Type.Sibni;
import static ch.jassapp.common.deck.Type.Under;
import ch.jassapp.common.player.CharteIschErfundeException;
import ch.jassapp.common.player.JassException;
import ch.jassapp.common.player.NedFarbeException;
import ch.jassapp.common.player.UntertrumpfenException;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author christoph
 */
public class TrumpfJassType extends AbstractJassType{
    private Color trumpfColor;
    private Comparator<Card> obeAbeComparator;
    public TrumpfJassType(Color trumpfColor) {
        this.trumpfColor = trumpfColor;
        obeAbeComparator = new ObeAbeJassType();
    }

    @Override
    protected void setCardValue(List<Card> deck) {
        for (Card card : deck) {
            switch (card.getType()) {
                case Sechsi:
                case Achti:
                case Sibni:
                    card.setValue(0);
                    break;
                case Nueni:
                    if(card.getColor() == trumpfColor) {
                        card.setValue(14);
                    } else {
                        card.setValue(0);
                    }
                    break;
                case Banner:
                    card.setValue(10);
                    break;
                case Under:
                    if(card.getColor() == trumpfColor) {
                        card.setValue(20);
                    } else {
                        card.setValue(2);
                    }
                    break;
                case Ober:
                    card.setValue(3);
                    break;
                case Koenig:
                    card.setValue(4);
                    break;
                case Ass:
                    card.setValue(11);
                    break;
            }
        }
    }

    @Override
    protected void setCardOrder(List<Card> deck) {
        for (Card card : deck) {
            switch (card.getType()) {
                case Sechsi:
                    card.setOrder(0);
                    break;
                case Sibni:
                    card.setOrder(1);
                    break;
                case Achti:
                    card.setOrder(2);
                    break;
                case Nueni:
                    if(card.getColor() == trumpfColor) {
                        card.setOrder(7);
                    } else {
                        card.setOrder(3);
                    }
                    break;
                case Banner:
                    if(card.getColor() == trumpfColor) {
                        card.setOrder(3);
                    } else {
                        card.setOrder(4);
                    }
                    break;
                case Under:
                    if(card.getColor() == trumpfColor) {
                        card.setOrder(8);
                    } else {
                        card.setOrder(5);
                    }
                    break;
                case Ober:
                    if(card.getColor() == trumpfColor) {
                        card.setOrder(4);
                    } else {
                        card.setOrder(6);
                    }
                    break;
                case Koenig:
                    if(card.getColor() == trumpfColor) {
                        card.setOrder(5);
                    } else {
                        card.setOrder(7);
                    }
                    break;
                case Ass:
                    if(card.getColor() == trumpfColor) {
                        card.setOrder(6);
                    } else {
                        card.setOrder(8);
                    }
                    break;
            }
        }
    }

    public int compare(Card o1, Card o2) {
        if(o1.getColor() == trumpfColor) {
            if(o2.getColor() == trumpfColor ) {
                //Beides Trumpf
                return o2.getOrder() - o1.getOrder();
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
                return obeAbeComparator.compare(o1, o2);
            } 
        }
    }

    @Override
    public void isCardAllowed(Card cardToPlay, List<Card> alreadyPlayedCards, List<Card> cardsFromPlayer) throws JassException{
        if(!cardsFromPlayer.contains(cardToPlay)) {
            throw new CharteIschErfundeException();
        }
        
        if(alreadyPlayedCards.isEmpty()) {
            return;
        } 
        
        boolean hasSameColorCard = false;
        for(Card cardFromPlayer: cardsFromPlayer) {
            if(cardFromPlayer.getColor() == playedCardColor) {
                if(cardFromPlayer.getColor() != trumpfColor || cardFromPlayer.getType() != Under) {
                    hasSameColorCard = true;
                    break;
                }
            }
        }
        
        if(hasSameColorCard && cardToPlay.getColor() != playedCardColor && playedCardColor == trumpfColor) {
            throw new NedFarbeException();
        }
        
        
        if(playedCardColor != trumpfColor && cardToPlay.getColor() == trumpfColor) {
            //Dont Untertrumpfen
            int highestTrumpfOrder = -1;
            for(Card card: alreadyPlayedCards) {
                if(card.getColor() == trumpfColor) {
                    if(card.getOrder() > highestTrumpfOrder) {
                        highestTrumpfOrder = card.getOrder();
                    }
                }
            }
            
            boolean hasDifferentCard = false;
            for(Card card: cardsFromPlayer) {
                if(card.getColor() != trumpfColor) {
                    hasDifferentCard = true;
                    break;
                }
            }
            
            if(hasDifferentCard && highestTrumpfOrder > cardToPlay.getOrder()) {
                throw new UntertrumpfenException();
            }
        }
    }

    @Override
    public String toString() {
        return "Trumpf (" + trumpfColor + ")";
    }
}

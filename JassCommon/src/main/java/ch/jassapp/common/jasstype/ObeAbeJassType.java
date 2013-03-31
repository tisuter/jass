/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jassapp.common.jasstype;

import ch.jassapp.common.deck.Card;
import static ch.jassapp.common.deck.Type.Achti;
import static ch.jassapp.common.deck.Type.Ass;
import static ch.jassapp.common.deck.Type.Banner;
import static ch.jassapp.common.deck.Type.Koenig;
import static ch.jassapp.common.deck.Type.Nueni;
import static ch.jassapp.common.deck.Type.Ober;
import static ch.jassapp.common.deck.Type.Sechsi;
import static ch.jassapp.common.deck.Type.Sibni;
import static ch.jassapp.common.deck.Type.Under;
import java.util.List;

/**
 *
 * @author christoph
 */
public class ObeAbeJassType extends AbstractJassType {

    @Override
    protected void setCardValue(List<Card> deck) {
        for (Card card : deck) {
            switch (card.getType()) {
                case Sechsi:
                case Sibni:
                case Nueni:
                    card.setValue(0);
                    break;
                case Achti:
                    card.setValue(8);
                    break;
                case Banner:
                    card.setValue(10);
                    break;
                case Under:
                    card.setValue(2);
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
                    card.setOrder(3);
                    break;
                case Banner:
                    card.setOrder(4);
                    break;
                case Under:
                    card.setOrder(5);
                    break;
                case Ober:
                    card.setOrder(6);
                    break;
                case Koenig:
                    card.setOrder(7);
                    break;
                case Ass:
                    card.setOrder(8);
                    break;
            }
        }
    }

    public int compare(Card o1, Card o2) {
        if (o1.getColor() == o2.getColor()) {
            return o2.getOrder() - o1.getOrder();
        }

        if (o2.getColor() == playedCardColor) {
            return 1;
        }
        
        if (o1.getColor() == playedCardColor) {
            return -1;
        }

        return o2.getOrder()- o1.getOrder();
    }
}

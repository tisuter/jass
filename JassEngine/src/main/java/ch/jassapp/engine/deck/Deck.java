/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jassapp.engine.deck;

import ch.jassapp.common.deck.Card;
import ch.jassapp.common.deck.Color;
import ch.jassapp.common.deck.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tisuter
 */
public class Deck {

    private List<Card> cards = new ArrayList<Card>();

    public Deck() {
        cards.add(new Card(Color.Rose, Type.Sechsi));
        cards.add(new Card(Color.Rose, Type.Sibni));
        cards.add(new Card(Color.Rose, Type.Achti));
        cards.add(new Card(Color.Rose, Type.Nueni));
        cards.add(new Card(Color.Rose, Type.Banner));
        cards.add(new Card(Color.Rose, Type.Under));
        cards.add(new Card(Color.Rose, Type.Ober));
        cards.add(new Card(Color.Rose, Type.Koenig));
        cards.add(new Card(Color.Rose, Type.Ass));
        cards.add(new Card(Color.Eichle, Type.Sechsi));
        cards.add(new Card(Color.Eichle, Type.Sibni));
        cards.add(new Card(Color.Eichle, Type.Achti));
        cards.add(new Card(Color.Eichle, Type.Nueni));
        cards.add(new Card(Color.Eichle, Type.Banner));
        cards.add(new Card(Color.Eichle, Type.Under));
        cards.add(new Card(Color.Eichle, Type.Ober));
        cards.add(new Card(Color.Eichle, Type.Koenig));
        cards.add(new Card(Color.Eichle, Type.Ass));
        cards.add(new Card(Color.Schelle, Type.Sechsi));
        cards.add(new Card(Color.Schelle, Type.Sibni));
        cards.add(new Card(Color.Schelle, Type.Achti));
        cards.add(new Card(Color.Schelle, Type.Nueni));
        cards.add(new Card(Color.Schelle, Type.Banner));
        cards.add(new Card(Color.Schelle, Type.Under));
        cards.add(new Card(Color.Schelle, Type.Ober));
        cards.add(new Card(Color.Schelle, Type.Koenig));
        cards.add(new Card(Color.Schelle, Type.Ass));
        cards.add(new Card(Color.Schilte, Type.Sechsi));
        cards.add(new Card(Color.Schilte, Type.Sibni));
        cards.add(new Card(Color.Schilte, Type.Achti));
        cards.add(new Card(Color.Schilte, Type.Nueni));
        cards.add(new Card(Color.Schilte, Type.Banner));
        cards.add(new Card(Color.Schilte, Type.Under));
        cards.add(new Card(Color.Schilte, Type.Ober));
        cards.add(new Card(Color.Schilte, Type.Koenig));
        cards.add(new Card(Color.Schilte, Type.Ass));
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void giveCards(List<Card>[] players) {
        players[0].clear();
        players[1].clear();
        players[2].clear();
        players[3].clear();
        
        for (int i = 0; i < cards.size(); i++) {
            int player = i / 3;
            player = player % 4;
            players[player].add(cards.get(i));
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (Card card : cards) {
            s += card + "-";
        }
        return s;
    }

    public void sort() {
        Collections.sort(cards);
    }
}

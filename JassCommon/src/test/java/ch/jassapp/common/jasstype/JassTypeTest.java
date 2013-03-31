/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jassapp.common.jasstype;

import ch.jassapp.common.deck.Card;
import ch.jassapp.common.deck.Color;
import ch.jassapp.common.deck.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 *
 * @author tisuter
 */
public class JassTypeTest extends TestCase {
    
    public JassTypeTest(String testName) {
        super(testName);
    }
    
    public void testObeCardComparator() {
        System.out.println("testObeCardComparator");
        AbstractJassType comparator = new ObeAbeJassType();

        comparator.setPlayedCardColor(Color.Schelle);
        List<Card> cards= new ArrayList<Card>();
        cards.add(new Card(Color.Rose, Type.Under));
        cards.add(new Card(Color.Schelle, Type.Sechsi));
        cards.add(new Card(Color.Rose, Type.Ass));
        cards.add(new Card(Color.Rose, Type.Ober));
        comparator.initDeck(cards);
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Schelle, Type.Sechsi));
        
        cards.clear();
        cards.add(new Card(Color.Schelle, Type.Under));
        cards.add(new Card(Color.Schelle, Type.Sechsi));
        cards.add(new Card(Color.Schelle, Type.Ass));
        cards.add(new Card(Color.Schelle, Type.Ober));
        comparator.initDeck(cards);
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Schelle, Type.Ass));
    }
    
    public void testUndeCardComparator() {
        System.out.println("testUndeCardComparator");
        AbstractJassType comparator = new UndeUfeJassType();

        comparator.setPlayedCardColor(Color.Schelle);
        List<Card> cards= new ArrayList<Card>();
        cards.add(new Card(Color.Rose, Type.Under));
        cards.add(new Card(Color.Schelle, Type.Sechsi));
        cards.add(new Card(Color.Rose, Type.Ass));
        cards.add(new Card(Color.Rose, Type.Ober));
        comparator.initDeck(cards);
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Schelle, Type.Sechsi));
        
        cards.clear();
        cards.add(new Card(Color.Schelle, Type.Under));
        cards.add(new Card(Color.Schelle, Type.Sechsi));
        cards.add(new Card(Color.Schelle, Type.Ass));
        cards.add(new Card(Color.Schelle, Type.Ober));
        comparator.initDeck(cards);
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Schelle, Type.Sechsi));
    }
    
    public void testTrumpfCardComparator() {
        System.out.println("testTrumpfCardComparator");
        AbstractJassType comparator = new TrumpfJassType(Color.Schelle);
        comparator.setPlayedCardColor(Color.Rose);
        
        List<Card> cards= new ArrayList<Card>();
        cards.add(new Card(Color.Rose, Type.Under));
        cards.add(new Card(Color.Schelle, Type.Sechsi));
        cards.add(new Card(Color.Rose, Type.Ass));
        cards.add(new Card(Color.Rose, Type.Ober));
        comparator.initDeck(cards);
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Schelle, Type.Sechsi));
        
        cards.clear();
        cards.add(new Card(Color.Rose, Type.Under));
        cards.add(new Card(Color.Rose, Type.Sechsi));
        cards.add(new Card(Color.Rose, Type.Ass));
        cards.add(new Card(Color.Rose, Type.Ober));
        comparator.initDeck(cards);
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Rose, Type.Ass));
        
        cards.clear();
        cards.add(new Card(Color.Schelle, Type.Under));
        cards.add(new Card(Color.Schelle, Type.Sechsi));
        cards.add(new Card(Color.Schelle, Type.Ass));
        cards.add(new Card(Color.Schelle, Type.Ober));
        comparator.initDeck(cards);
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Schelle, Type.Under));
        
        cards.clear();
        cards.add(new Card(Color.Schelle, Type.Koenig));
        cards.add(new Card(Color.Schelle, Type.Nueni));
        cards.add(new Card(Color.Schelle, Type.Ass));
        cards.add(new Card(Color.Schelle, Type.Ober));
        comparator.initDeck(cards);
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Schelle, Type.Nueni));
        
        cards.clear();
        cards.add(new Card(Color.Schelle, Type.Koenig));
        cards.add(new Card(Color.Schelle, Type.Sechsi));
        cards.add(new Card(Color.Schelle, Type.Ass));
        cards.add(new Card(Color.Schelle, Type.Ober));
        comparator.initDeck(cards);
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Schelle, Type.Ass));
    }
    
    public void testAllowCardToPlay() {
        System.out.println("testAllowCardToPlay");
        
        
        AbstractJassType obeAbe = new ObeAbeJassType();
        AbstractJassType undeUfe = new UndeUfeJassType();
        AbstractJassType trumpf = new TrumpfJassType(Color.Rose);

        List<Card> alreadyPlayedCards= new ArrayList<Card>();
        assertEquals(obeAbe.isCardAllowed(new Card(Color.Rose, Type.Under), alreadyPlayedCards, new ArrayList<Card>()), 3);
        assertEquals(undeUfe.isCardAllowed(new Card(Color.Rose, Type.Under), alreadyPlayedCards, new ArrayList<Card>()), 3);
        assertEquals(trumpf.isCardAllowed(new Card(Color.Rose, Type.Under), alreadyPlayedCards, new ArrayList<Card>()), 3);
        
        List<Card> myCards = new ArrayList<Card>();
        myCards.add(new Card(Color.Rose, Type.Ober));
                
        assertEquals(obeAbe.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards), 0);
        assertEquals(undeUfe.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards), 0);
        assertEquals(trumpf.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards), 0);
        
        undeUfe.setPlayedCardColor(Color.Rose);
        obeAbe.setPlayedCardColor(Color.Rose);
        trumpf.setPlayedCardColor(Color.Rose);
        alreadyPlayedCards.add(new Card(Color.Rose, Type.Achti));
        
        assertEquals(obeAbe.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards), 0);
        assertEquals(undeUfe.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards), 0);
        assertEquals(trumpf.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards), 0);
        
        myCards.add(new Card(Color.Schelle, Type.Under));
        assertEquals(obeAbe.isCardAllowed(myCards.get(1), alreadyPlayedCards, myCards), 1);
        assertEquals(undeUfe.isCardAllowed(myCards.get(1), alreadyPlayedCards, myCards), 1);
        assertEquals(trumpf.isCardAllowed(myCards.get(1), alreadyPlayedCards, myCards), 1);
        
        myCards.remove(0);
        assertEquals(obeAbe.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards), 0);
        assertEquals(undeUfe.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards), 0);
        assertEquals(trumpf.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards), 0);
        
        
        //Buur mus mer ned Spiele...
        trumpf.setPlayedCardColor(Color.Rose);
        myCards.clear();
        myCards.add(new Card(Color.Schelle, Type.Under));
        myCards.add(new Card(Color.Rose, Type.Under));
        assertEquals(trumpf.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards), 0);
        assertEquals(trumpf.isCardAllowed(myCards.get(1), alreadyPlayedCards, myCards), 0);
        
        //Nicht Untertrumpfen...
        trumpf.setPlayedCardColor(Color.Schelle);
        myCards.clear();
        alreadyPlayedCards.clear();
        alreadyPlayedCards.add(new Card(Color.Schelle, Type.Ass));
        alreadyPlayedCards.add(new Card(Color.Rose, Type.Nueni));

        myCards.add(new Card(Color.Schelle, Type.Under));
        myCards.add(new Card(Color.Rose, Type.Banner));
        trumpf.setCardOrder(myCards);
        trumpf.setCardOrder(alreadyPlayedCards);
        assertEquals(trumpf.isCardAllowed(myCards.get(1), alreadyPlayedCards, myCards), 2);
        myCards.remove(0);
        assertEquals(trumpf.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards), 0);
        
        myCards.add(new Card(Color.Rose, Type.Under));
        trumpf.setCardOrder(myCards);
        assertEquals(trumpf.isCardAllowed(myCards.get(1), alreadyPlayedCards, myCards), 0);
    }
    
}

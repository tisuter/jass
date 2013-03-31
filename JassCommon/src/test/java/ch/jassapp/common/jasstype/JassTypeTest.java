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
    
}

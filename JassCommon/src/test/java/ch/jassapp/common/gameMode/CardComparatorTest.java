/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jassapp.common.gameMode;

import ch.jassapp.common.deck.Card;
import ch.jassapp.common.deck.Color;
import ch.jassapp.common.deck.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author tisuter
 */
public class CardComparatorTest extends TestCase {
    
    public CardComparatorTest(String testName) {
        super(testName);
    }
    
    public void testObeCardComparator() {
        System.out.println("testObeCardComparator");
        CardComparator comparator = new ObeCardComparator();

        comparator.setPlayedCardColor(Color.Schelle);
        List<Card> cards= new ArrayList<Card>();
        cards.add(new Card(Color.Rose, Type.Under));
        cards.add(new Card(Color.Schelle, Type.Sechsi));
        cards.add(new Card(Color.Rose, Type.Ass));
        cards.add(new Card(Color.Rose, Type.Ober));
        
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Schelle, Type.Sechsi));
        
        cards.clear();
        cards.add(new Card(Color.Schelle, Type.Under));
        cards.add(new Card(Color.Schelle, Type.Sechsi));
        cards.add(new Card(Color.Schelle, Type.Ass));
        cards.add(new Card(Color.Schelle, Type.Ober));
        
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Schelle, Type.Ass));
    }
    
    public void testUndeCardComparator() {
        System.out.println("testUndeCardComparator");
        CardComparator comparator = new UndeCardComparator();

        comparator.setPlayedCardColor(Color.Schelle);
        List<Card> cards= new ArrayList<Card>();
        cards.add(new Card(Color.Rose, Type.Under));
        cards.add(new Card(Color.Schelle, Type.Sechsi));
        cards.add(new Card(Color.Rose, Type.Ass));
        cards.add(new Card(Color.Rose, Type.Ober));
        
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Schelle, Type.Sechsi));
        
        cards.clear();
        cards.add(new Card(Color.Schelle, Type.Under));
        cards.add(new Card(Color.Schelle, Type.Sechsi));
        cards.add(new Card(Color.Schelle, Type.Ass));
        cards.add(new Card(Color.Schelle, Type.Ober));
        
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Schelle, Type.Sechsi));
    }
    
    public void testTrumpfCardComparator() {
        System.out.println("testTrumpfCardComparator");
        CardComparator comparator = new TrumpfCardComparator();
        ((TrumpfCardComparator)comparator).setTrumpfColor(Color.Schelle);
        comparator.setPlayedCardColor(Color.Rose);
        
        List<Card> cards= new ArrayList<Card>();
        cards.add(new Card(Color.Rose, Type.Under));
        cards.add(new Card(Color.Schelle, Type.Sechsi));
        cards.add(new Card(Color.Rose, Type.Ass));
        cards.add(new Card(Color.Rose, Type.Ober));
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Schelle, Type.Sechsi));
        
        cards.clear();
        cards.add(new Card(Color.Rose, Type.Under));
        cards.add(new Card(Color.Rose, Type.Sechsi));
        cards.add(new Card(Color.Rose, Type.Ass));
        cards.add(new Card(Color.Rose, Type.Ober));
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Rose, Type.Ass));
        
        cards.clear();
        cards.add(new Card(Color.Schelle, Type.Under));
        cards.add(new Card(Color.Schelle, Type.Sechsi));
        cards.add(new Card(Color.Schelle, Type.Ass));
        cards.add(new Card(Color.Schelle, Type.Ober));
        
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Schelle, Type.Under));
        
        cards.clear();
        cards.add(new Card(Color.Schelle, Type.Koenig));
        cards.add(new Card(Color.Schelle, Type.Nueni));
        cards.add(new Card(Color.Schelle, Type.Ass));
        cards.add(new Card(Color.Schelle, Type.Ober));
        
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Schelle, Type.Nueni));
        
        cards.clear();
        cards.add(new Card(Color.Schelle, Type.Koenig));
        cards.add(new Card(Color.Schelle, Type.Sechsi));
        cards.add(new Card(Color.Schelle, Type.Ass));
        cards.add(new Card(Color.Schelle, Type.Ober));
        
        Collections.sort(cards, comparator);
        assertEquals(cards.get(0), new Card(Color.Schelle, Type.Ass));
    }
    
}

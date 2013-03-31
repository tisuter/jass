/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jassapp.engine.deck;

import ch.jassapp.common.deck.Card;
import ch.jassapp.common.deck.CardCollection;
import ch.jassapp.common.deck.Color;
import ch.jassapp.common.jasstype.AbstractJassType;
import ch.jassapp.common.jasstype.ObeAbeJassType;
import ch.jassapp.common.jasstype.TrumpfJassType;
import ch.jassapp.common.jasstype.UndeUfeJassType;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 *
 * @author tisuter
 */
public class DeckTest extends TestCase {
    
    public DeckTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of shuffle method, of class Deck.
     */
    public void testShuffle() {
        System.out.println("shuffle");
        Deck deck = new Deck();
        String s1 = deck.toString();
        deck.shuffle();
        String s2 = deck.toString();
        Deck deck2 = new Deck();
        deck2.shuffle();
        String s3 = deck2.toString();
        assertFalse(s1.equals(s2));
        assertFalse(s1.equals(s3));
        assertFalse(s2.equals(s3));
        System.out.println(s2);
    }
    
    public void testGiveCards() {
        System.out.println("shuffle");
        Deck deck = new Deck();
        deck.shuffle();
        List<Card>[] players = new List[4];
        players[0] = new ArrayList<Card>();
        players[1] = new ArrayList<Card>();
        players[2] = new ArrayList<Card>();
        players[3] = new ArrayList<Card>();
        deck.giveCards(players);
        assertEquals(players[0].size(), 9);
        assertEquals(players[1].size(), 9);
        assertEquals(players[2].size(), 9);
        assertEquals(players[3].size(), 9);
    }
    
    
    public void testSort() {
        System.out.println("Sort");
        Deck deck = new Deck();
        deck.shuffle();
        String s1 = deck.toString();
        deck.sort();
        String s2 = deck.toString();
        assertFalse(s1.equals(s2));
    }
    
    public void testCount() {
        System.out.println("CountTotal");
        Deck deck = new Deck();
        //deck.shuffle();
        CardCollection collection = new CardCollection();
        List<Card>[] players = new List[4];
        players[0] = new ArrayList<Card>();
        players[1] = new ArrayList<Card>();
        players[2] = new ArrayList<Card>();
        players[3] = new ArrayList<Card>();
        deck.giveCards(players);
        
        for(int player = 0; player<4; player++) {
            for(Card card: players[player]) {
                collection.add(card);
            }
        }
    
        AbstractJassType jassType = new ObeAbeJassType();
        jassType.initDeck(collection.getCards());
        assertEquals(collection.CountPoints(), 152);
        
        jassType = new UndeUfeJassType();
        jassType.initDeck(collection.getCards());
        assertEquals(collection.CountPoints(), 152);
        
        jassType = new TrumpfJassType(Color.Rose);
        jassType.initDeck(collection.getCards());
        assertEquals(collection.CountPoints(), 152);
        
        jassType = new TrumpfJassType(Color.Eichle);
        jassType.initDeck(collection.getCards());
        assertEquals(collection.CountPoints(), 152);
        
        jassType = new TrumpfJassType(Color.Schelle);
        jassType.initDeck(collection.getCards());
        assertEquals(collection.CountPoints(), 152);
        
        jassType = new TrumpfJassType(Color.Schilte);
        jassType.initDeck(collection.getCards());
        assertEquals(collection.CountPoints(), 152);
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jassapp.common.jasstype;

import ch.jassapp.common.deck.Card;
import ch.jassapp.common.deck.Color;
import ch.jassapp.common.deck.Type;
import ch.jassapp.common.player.CharteIschErfundeException;
import ch.jassapp.common.player.JassException;
import ch.jassapp.common.player.NedFarbeException;
import ch.jassapp.common.player.UntertrumpfenException;
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
    
    public void testAllowCardToPlay() throws JassException {
        System.out.println("testAllowCardToPlay");
        
        
        AbstractJassType obeAbe = new ObeAbeJassType();
        AbstractJassType undeUfe = new UndeUfeJassType();
        AbstractJassType trumpf = new TrumpfJassType(Color.Rose);

        List<Card> alreadyPlayedCards= new ArrayList<Card>();
        
        boolean error;
        try{
            error = false;
            obeAbe.isCardAllowed(new Card(Color.Rose, Type.Under), alreadyPlayedCards, new ArrayList<Card>());
            fail("No Exception happened");
        } catch (CharteIschErfundeException ex) {
            error = true;
        }
        assertTrue(error);
        
        
        try{
            error = false;
            undeUfe.isCardAllowed(new Card(Color.Rose, Type.Under), alreadyPlayedCards, new ArrayList<Card>());
            fail("No Exception happened");
        } catch (CharteIschErfundeException ex) {
            error = true;
        }
        assertTrue(error);

        try{
            error = false;
            trumpf.isCardAllowed(new Card(Color.Rose, Type.Under), alreadyPlayedCards, new ArrayList<Card>());
            fail("No Exception happened");
        } catch (CharteIschErfundeException ex) {
            error = true;
        }
        assertTrue(error);

        List<Card> myCards = new ArrayList<Card>();
        myCards.add(new Card(Color.Rose, Type.Ober));
        
        try {
            obeAbe.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards);
            undeUfe.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards);
            trumpf.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards);
        } catch(JassException ex) {
            fail("No exception should occur...");
        }
        
        undeUfe.setPlayedCardColor(Color.Rose);
        obeAbe.setPlayedCardColor(Color.Rose);
        trumpf.setPlayedCardColor(Color.Rose);
        alreadyPlayedCards.add(new Card(Color.Rose, Type.Achti));
        
        try {
            obeAbe.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards);
            undeUfe.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards);
            trumpf.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards);
        } catch(JassException ex) {
            fail("No exception should occur...");
        }
        myCards.add(new Card(Color.Schelle, Type.Under));
        
        try{
            error = false;
            obeAbe.isCardAllowed(myCards.get(1), alreadyPlayedCards, myCards);
            fail("No Exception happened");
        } catch (NedFarbeException ex) {
            error = true;
        }
        assertTrue(error);
        try{
            error = false;
            undeUfe.isCardAllowed(myCards.get(1), alreadyPlayedCards, myCards);
            fail("No Exception happened");
        } catch (NedFarbeException ex) {
            error = true;
        }
        assertTrue(error);
        try{
            error = false;
            trumpf.isCardAllowed(myCards.get(1), alreadyPlayedCards, myCards);
            fail("No Exception happened");
        } catch (NedFarbeException ex) {
            error = true;
        }
        assertTrue(error);
        
        myCards.remove(0);
        try {
            obeAbe.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards);
            undeUfe.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards);
            trumpf.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards);
        } catch(JassException ex) {
            fail("No exception should occur...");
        }
        //Buur mus mer ned Spiele...
        trumpf.setPlayedCardColor(Color.Rose);
        myCards.clear();
        myCards.add(new Card(Color.Schelle, Type.Under));
        myCards.add(new Card(Color.Rose, Type.Under));

        try {
            trumpf.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards);
            trumpf.isCardAllowed(myCards.get(1), alreadyPlayedCards, myCards);
        } catch(JassException ex) {
            fail("No exception should occur...");
        }
        
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
        
        try{
            error = false;
            trumpf.isCardAllowed(myCards.get(1), alreadyPlayedCards, myCards);
            fail("No Exception happened");
        } catch (UntertrumpfenException ex) {
            error = true;
        }
        assertTrue(error);

        myCards.remove(0);
        try {
            trumpf.isCardAllowed(myCards.get(0), alreadyPlayedCards, myCards);
        } catch(JassException ex) {
            fail("No exception should occur...");
        }
        myCards.add(new Card(Color.Rose, Type.Under));
        trumpf.setCardOrder(myCards);
        try {
            trumpf.isCardAllowed(myCards.get(1), alreadyPlayedCards, myCards);
        } catch(JassException ex) {
            fail("No exception should occur...");
        }       
    }
    
}

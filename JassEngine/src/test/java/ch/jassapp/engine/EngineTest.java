/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jassapp.engine;

import ch.jassapp.common.deck.Card;
import ch.jassapp.common.deck.Color;
import ch.jassapp.common.gameengine.GameEngineObserver;
import ch.jassapp.common.jasstype.AbstractJassType;
import ch.jassapp.common.jasstype.ObeAbeJassType;
import ch.jassapp.common.jasstype.TrumpfJassType;
import ch.jassapp.common.jasstype.UndeUfeJassType;
import ch.jassapp.common.player.JassException;
import ch.jassapp.common.player.Player;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author christoph
 */
public class EngineTest extends TestCase {

    private static final int ROUNDS = 250;
    
    public EngineTest(String testName) {
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

    public void testGame() {
        System.out.println("testGame");
        
        List<Player> players = new ArrayList<Player>();
        players.add(new MockPlayer());
        players.add(new MockPlayer());
        players.add(new MockPlayer());
        players.add(new MockPlayer());
        
        Engine engine = new Engine(players);
        
        engine.play(ROUNDS);      
        assertEquals((engine.getTotalPoints(0) + engine.getTotalPoints(1)) % 157, 0);
    }

    private class MockPlayer implements Player {

        int roundId = 0;
        int playerCard = 0;
        List<Card> cards;

        public void init(int playerID, GameEngineObserver gameEngineObserver) {
        }

        public AbstractJassType selectJassTypeForRound() {
            switch (roundId % 6) {
                case 0:
                    return new ObeAbeJassType();
                case 1:
                    return new TrumpfJassType(Color.Eichle);
                case 2:
                    return new TrumpfJassType(Color.Rose);
                case 3:
                    return new TrumpfJassType(Color.Schelle);
                case 4:
                    return new TrumpfJassType(Color.Schilte);
                default:
                    return new UndeUfeJassType();
            }
        }

        public void newRound(int roundId, List<Card> playerCards, AbstractJassType selectedJassType) {
            this.roundId = roundId;
            this.cards = playerCards;
        }

        public Card playCardInTurn(List<Card> alreadyPlayedCars) {
            playerCard++;
            playerCard = playerCard % 9;
            return cards.get(playerCard);
        }

        public void illegalCard(Card playedCars, JassException reason) {
        }

        public void turnFinished(List<Card> cardsPlayed, int wonByPlayer) {
        }

        public void roundFinished(int pointMadeByTeam) {
        }
    }
}

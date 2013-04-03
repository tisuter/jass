/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jassapp.player.random;

import ch.jassapp.common.deck.Card;
import ch.jassapp.common.deck.Color;
import ch.jassapp.common.gameengine.GameEngineObserver;
import ch.jassapp.common.jasstype.AbstractJassType;
import ch.jassapp.common.jasstype.ObeAbeJassType;
import ch.jassapp.common.jasstype.TrumpfJassType;
import ch.jassapp.common.jasstype.UndeUfeJassType;
import ch.jassapp.common.player.JassException;
import ch.jassapp.common.player.Player;
import java.util.List;

/**
 *
 * @author tisuter
 */
public class RandomPlayer implements Player {

    private int roundId = 0;
    private int playerCard = 0;
    private List<Card> cards;

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
    
    @Override
    public String toString() {
        return "RandomPlayer";
    }
}

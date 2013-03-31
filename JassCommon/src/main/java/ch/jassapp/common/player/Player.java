/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jassapp.common.player;

import ch.jassapp.common.deck.Card;
import ch.jassapp.common.gameengine.GameEngineObserver;
import ch.jassapp.common.jasstype.AbstractJassType;
import java.util.List;

/**
 *
 * @author christoph
 */
public interface Player {
    public void init(int playerID, GameEngineObserver gameEngineObserver);
        
    public AbstractJassType selectJassTypeForRound();
    public void newRound(int roundID, List<Card> playerCards, AbstractJassType selectedJassType);
    
    public Card playCardInTurn(List<Card> alreadyPlayedCars);
    
    /**
     * 
     * @param playedCars
     * @param reason following codes are allowed:
     * 1. You have to use the correct Color (Exceptions: You are out of this Color, Trumpf)
     * 2. Not Untertrumpfen (Exceptions: You have no other choice)
     * 3. You don not have this card in your 'playerCards'
     */
    public void illegalCard(Card playedCars, int reason);
    public void turnFinished(List<Card> cardsPlayed, int wonByPlayer);   
    public void roundFinished(int pointMadeByTeam);
}

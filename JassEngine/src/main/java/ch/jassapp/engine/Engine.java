/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jassapp.engine;

import ch.jassapp.common.deck.Card;
import ch.jassapp.common.deck.CardCollection;
import ch.jassapp.common.gameengine.GameEngineObserver;
import ch.jassapp.common.jasstype.AbstractJassType;
import ch.jassapp.common.player.Player;
import ch.jassapp.engine.deck.Deck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author christoph
 */
public class Engine implements GameEngineObserver {

    private List<Player> players;
    private List<Team> teams;
    private Deck deck;

    public Engine(List<Player> players) {
        this.players = players;
        teams = new ArrayList<Team>();
        teams.add(new Team(players.get(0), players.get(2)));
        teams.add(new Team(players.get(1), players.get(3)));
        deck = new Deck();
    }

    public int getTeamId(int playerId) {
        if (playerId == 0 || playerId == 2) {
            return 0;
        }
        if (playerId == 1 || playerId == 3) {
            return 1;
        }
        return -1;
    }

    public int getTotalPoints(int teamId) {
        return teams.get(teamId).getTotalPoints();
    }

    public int getPointsPerRound(int teamId, int roundId) {
        return teams.get(teamId).getPointsPerRound(roundId);
    }

    public int getNumberOfRounds() {
        return teams.get(0).getNumberOfRounds();
    }

    private int getNextPlayerId(int actualPlayerId) {
        return (actualPlayerId+1) % 4;
    }

    /**
     *
     * @param maxPoints
     * @return Team which has won
     */
    public int playUntilMaxPointsReached(int maxPoints) {
        int startingPlayer = 0;
        int team0Point = teams.get(0).getTotalPoints();
        int team1Point = teams.get(1).getTotalPoints();
        int roundId = 0;
        while (team0Point < maxPoints && team1Point < maxPoints) {

            RoundManager roundManager = new RoundManager(roundId, startingPlayer);
            roundManager.playRound();
            startingPlayer = getNextPlayerId(startingPlayer);

            team0Point = teams.get(0).getTotalPoints();
            team1Point = teams.get(1).getTotalPoints();
            roundId++;
        }

        if (team0Point > team1Point) {
            return 0;
        } else {
            return 1;
        }
    }

    private class RoundManager {

        private List<Card>[] playerCards;
        private int roundId;
        private AbstractJassType jassType;
        private int startingPlayer;
        private List<Card> cardsPlayedInRound;
        private CardCollection[] cardsWonByTeam;
        
        public RoundManager(int roundId, int startingPlayer) {
            this.roundId = roundId;
            this.playerCards = new List[4];
            this.cardsWonByTeam = new CardCollection[2];
            this.startingPlayer = startingPlayer;
            playerCards[0] = new ArrayList<Card>();
            playerCards[1] = new ArrayList<Card>();
            playerCards[2] = new ArrayList<Card>();
            playerCards[3] = new ArrayList<Card>();
            cardsWonByTeam[0] = new CardCollection();
            cardsWonByTeam[1] = new CardCollection();
            
            cardsPlayedInRound = new ArrayList<Card>();
        }
       
        
        private void playRound() {
            initRound();
            System.out.println("Round started: " + jassType.toString());
            
            for(int turnId = 0; turnId<9; turnId++){
                playTurn();
            } 
            
            updatePoints();
            System.out.println("Rounds Played: " + roundId + "; Team0: " + getTotalPoints(0) + "; Team1: " + getTotalPoints(1));
        }
        
        private void initRound() {
            deck.shuffle();
            deck.giveCards(playerCards);
            
            jassType = players.get(startingPlayer).selectJassTypeForRound();
            jassType.initDeck(deck.getCards());
            
            for(int i = 0; i<4; i++) {
                players.get(i).newRound(roundId, playerCards[i], jassType);
            }
        } 

        private void playTurn() {
            int playerInTurnId = startingPlayer;
            List<Card> cardsPlayedInTurn = new ArrayList<Card>();
            for(int i = 0; i<4; i++) {
                Player playerInTurn = players.get(playerInTurnId);
                boolean cardAccepted = false;
                Card playedCard = null;
                while(!cardAccepted) {
                    //TODO: UGLY Error Code... 
                    playedCard = playerInTurn.playCardInTurn(cardsPlayedInTurn);
                    int errorCode = cardCanBePlayed(playedCard, cardsPlayedInTurn, playerCards[playerInTurnId]);
                    if(errorCode == 0) {
                        cardAccepted = true;
                    } else {
                        playerInTurn.illegalCard(playedCard, errorCode);
                    }          
                }
                if(i == 0) {
                    //First Card
                    jassType.setPlayedCardColor(playedCard.getColor());
                }
                
                cardsPlayedInTurn.add(playedCard);
                cardsPlayedInRound.add(playedCard);
                
                playerInTurnId = getNextPlayerId(playerInTurnId);
            }
                          
            //Set Starting Player
            Collections.sort(cardsPlayedInTurn, jassType);
            startingPlayer = getOwnerOfCard(cardsPlayedInTurn.get(0));
            int teamId = getTeamId(startingPlayer);
            cardsWonByTeam[teamId].addAll(cardsPlayedInTurn);
            
            for(Player player: players) {
                player.turnFinished(cardsPlayedInTurn, startingPlayer);
            }
        }

        private int cardCanBePlayed(Card playedCard, List<Card> cardsPlayedInTurn, List<Card> playerCards) {
            List<Card> unusedPlayerCards = new ArrayList<Card>();
            for(Card playerCard: playerCards) {
                if(!cardsPlayedInRound.contains(playerCard)) {
                    unusedPlayerCards.add(playerCard);
                }
            }
            
            for(Card card: cardsPlayedInRound) {
                if(playedCard.equals(card)){
                    return 1;
                }                
            }
            
            return jassType.isCardAllowed(playedCard, cardsPlayedInTurn, unusedPlayerCards);
        }
        
        private int getOwnerOfCard(Card card) {
            for(int i = 0; i < 4; i++) {
                List<Card> cards = playerCards[i];
                for(Card playerCard : cards) {
                    if(card.equals(playerCard)) {
                        return i;
                    }
                }
            }
            
            return -1;
        }

        private void updatePoints() {
            int winnerTeam = getTeamId(startingPlayer);
            
            int team0Points = cardsWonByTeam[0].CountPoints();
            if(winnerTeam == 0) {
                team0Points += 5;
            }
            int team1Points = cardsWonByTeam[1].CountPoints();
            if(winnerTeam == 1) {
                team1Points += 5;
            }
            
            teams.get(0).addPoints(team0Points);
            teams.get(1).addPoints(team1Points);
            
            players.get(0).roundFinished(team0Points);
            players.get(1).roundFinished(team1Points);
            players.get(2).roundFinished(team0Points);
            players.get(3).roundFinished(team1Points);
        }
    }
}

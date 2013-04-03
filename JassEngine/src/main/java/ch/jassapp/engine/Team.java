/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jassapp.engine;

import ch.jassapp.common.player.Player;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author christoph
 */
public class Team {

    private Player player1;
    private Player player2;
    private List<Integer> pointsPerRound;
    
    public Team(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        pointsPerRound = new ArrayList<Integer>();
    }

    public int getTotalPoints() {
        int total = 0;
        for(int points: pointsPerRound) {
            total += points;
        }
        return total;    
    }

    public int getPointsPerRound(int roundId) {
        return pointsPerRound.get(roundId);
    }

    public int getNumberOfRounds() {
        return pointsPerRound.size();
    }

    public void addPoints(int points) {
        pointsPerRound.add(points);
    }

    @Override
    public String toString() {
        return player1 + " & " + player2;
    }
    
}

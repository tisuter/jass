/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jassapp.common.gameengine;

/**
 *
 * @author christoph
 */
public interface GameEngineObserver {
    
    public int getTeamId(int playerId);
    public int getTotalPoints(int teamId);
    public int getPointsPerRound(int teamId, int roundId);
    public int getNumberOfRounds();
}

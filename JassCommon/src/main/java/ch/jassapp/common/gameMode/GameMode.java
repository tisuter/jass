/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.jassapp.common.gameMode;

import ch.jassapp.common.deck.Color;

/**
 *
 * @author tisuter
 */
public class GameMode {
    private Modes mode;
    private Color trumpfColor;

    public GameMode(Modes mode, Color trumpfColor) {
        this.mode = mode;
        this.trumpfColor = trumpfColor;
    }

    public Modes getMode() {
        return mode;
    }

    public Color getTrumpfColor() {
        return trumpfColor;
    }
}

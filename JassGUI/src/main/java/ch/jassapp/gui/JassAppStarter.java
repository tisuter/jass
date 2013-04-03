/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.jassapp.gui;

import ch.jassapp.common.player.Player;
import ch.jassapp.engine.Engine;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author tisuter
 */
public class JassAppStarter {
    private String configFile;
    private String player0Class;
    private String player1Class;
    private String player2Class;
    private String player3Class;
    private List<Player> players;
    private int numberOfRounds;
    private Engine engine;
    
    public JassAppStarter(String configFile) {
        System.out.println("Starting JassApp");
        this.configFile = configFile;
        players = new ArrayList<Player>();
    }
    
    public void start() {
        loadConfig();
        initPlayers();
        startGameEngine();
    }
    
    
    private void loadConfig() {
        System.out.println("Loading Config from: "+ configFile);
        Properties config = new Properties();
        try {
            config.load(new FileInputStream(configFile));
            player0Class = loadStringProperty(config, "Player0");
            player1Class = loadStringProperty(config, "Player1");
            player2Class = loadStringProperty(config, "Player2");
            player3Class = loadStringProperty(config, "Player3");
            numberOfRounds = loadIntProperty(config, "NumberOfRounds");
        } catch(IOException ex) {
            System.out.println("Error during loading config: "+ ex.getMessage());
        }
    }

    private void initPlayers() {
        try {
            players.add((Player) Class.forName(player0Class).newInstance());
            players.add((Player) Class.forName(player1Class).newInstance());
            players.add((Player) Class.forName(player2Class).newInstance());
            players.add((Player) Class.forName(player3Class).newInstance());
        } catch (InstantiationException ex) {
            System.out.println("InstantiationException during loading config: "+ ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println("IllegalAccessException during loading config: "+ ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException during loading config: "+ ex.getMessage());
        }
    }
    
    private String loadStringProperty(Properties config, String propertyName) {
        String property = config.getProperty(propertyName, "");
        
        if(property.equals("")) {
            System.out.println("Property " + propertyName + " not found in Config.");
        }
        
        return property;
    }

    private int loadIntProperty(Properties config, String propertyName) {
        int property = Integer.parseInt(config.getProperty(propertyName, "-1"));
        
        if(property == -1) {
            System.out.println("Property " + propertyName + " not found in Config.");
        }
        
        return property;
    }

    private void startGameEngine() {
        engine = new Engine(players);
        engine.play(numberOfRounds);
    }
}

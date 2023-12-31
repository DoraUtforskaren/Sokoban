package Controller;

import model.Player;
import view.GamePanel;

import javax.swing.*;
import java.awt.event.*;


/**
 * The ButtonControlHandler class implements the ActionListener interface
 * and handles ActionEvents generated by JButton components in the application.
 */
public class ButtonControlHandler implements ActionListener {
    private GamePanel gamePanel;
    private Player player;

    
    /**
     * Creates a new ButtonControlHandler instance that associates a Player instance, 
     * a KeyHandler instance, and a GamePanel instance.
     * 
     * @param player The Player instance to associate with this ButtonControlHandler.
     * @param keyHandler The KeyHandler instance to associate with this ButtonControlHandler.
     * @param gamePanel The GamePanel instance to associate with this ButtonControlHandler.
     */
    public ButtonControlHandler(Player player, GamePanel gamePanel) {
        this.player = player;

        this.gamePanel = gamePanel;
    }

    /**
     * Invoked when an action occurs.
     * 
     * @param e The ActionEvent to be processed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        switch (source.getText().toUpperCase()) {
            case "UP":
                player.update("UP");
                break;
            case "DOWN":
                player.update("DOWN");
                break;
            case "LEFT":
                player.update("LEFT");
                break;
            case "RIGHT":
                player.update("RIGHT");
                break;
        }

        gamePanel.update();
        if(gamePanel.getMap().checkIfWin()) {
			 gamePanel.levelComplete(gamePanel);
		 }
        
    }

    
    /**
     * Creates a JButton with the specified text and adds this ButtonControlHandler as 
     * an ActionListener to the JButton.
     * 
     * @param text The text to be displayed on the JButton.
     * @return The created JButton.
     */
    public JButton createButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(this);
        return button;
    }
}

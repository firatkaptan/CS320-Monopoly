package monopoly.controller;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import monopoly.gamepanel.Map;
import monopoly.gamepanel.Monopoly;
import monopoly.main.Main;
import monopoly.model.Dice;
import monopoly.model.Player;
import monopoly.model.Token;

public class MenuController {

	public void play(MainController controller){
	
		if(sameNickName(controller)){
			JOptionPane.showMessageDialog(null, "Select different Nick Names for each player!");
		}else if(anyFieldNull(controller)){
			JOptionPane.showMessageDialog(null, "Please fill all of the player names !");
		}else{
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			Main.frame.setSize(dim.width-120,dim.height-120); 
			int width = Main.frame.getWidth();
			int height = Main.frame.getHeight();
			controller.map = new Map(height, controller);
			controller.monopoly = new Monopoly(controller);
			controller.setView(controller.monopoly, width*4/5, height);
			initComponents(controller);
			setTurnLimit(controller);
			Player p = controller.players[0];
			controller.setCurrentPlayer(p);
			updateText(controller.monopoly.lblCurrentPlayer, p.getName());
			updateText(controller.monopoly.lblCurrentTurn, String.valueOf(controller.currentTurn));
			updateText(controller.monopoly.lblTurnLimit, String.valueOf(controller.numberOfTurns));
			controller.dice1.roll();
			controller.dice2.roll();
			updateDiceImage(controller.dice1.getValue(), controller.monopoly.lblDice1);
			updateDiceImage(controller.dice2.getValue(), controller.monopoly.lblDice2);
		}
	}

	public void updateDiceImage(int faceValue, JLabel label){
		if(faceValue == 1)
			label.setIcon(new ImageIcon(Monopoly.class.getResource("/dice_1.png")));
		else if(faceValue == 2)
			label.setIcon(new ImageIcon(Monopoly.class.getResource("/dice_2.png")));
		else if(faceValue == 3)
			label.setIcon(new ImageIcon(Monopoly.class.getResource("/dice_3.png")));
		else if(faceValue == 4)
			label.setIcon(new ImageIcon(Monopoly.class.getResource("/dice_4.png")));
		else if(faceValue == 5)
			label.setIcon(new ImageIcon(Monopoly.class.getResource("/dice_5.png")));
		else if(faceValue == 6)
			label.setIcon(new ImageIcon(Monopoly.class.getResource("/dice_6.png")));

	}

	private void updateText(JLabel label, String str){
		label.setText(label.getText() + str);
	}
	
	private void setTurnLimit(MainController controller){
		JComboBox<Integer> comboBox = controller.getMenu().comboBox;
		int turn = (int) comboBox.getSelectedItem();
		controller.numberOfTurns = turn;
	}
	
	private void initComponents(MainController controller){
		controller.dice1 = new Dice();
		controller.dice2 = new Dice();
		controller.players = new Player[4];
		controller.tokens = new Token[4];
		String p1Name = controller.getMenu().txtFieldPlayer1.getText();
		String p2Name = controller.getMenu().txtFieldPlayer2.getText();
		String p3Name = controller.getMenu().txtFieldPlayer3.getText();
		String p4Name = controller.getMenu().txtFieldPlayer4.getText();
		initTokens(controller);
		Player p1 = new Player(p1Name, controller.tokens[0]);
		Player p2 = new Player(p2Name, controller.tokens[1]);
		Player p3 = new Player(p3Name, controller.tokens[2]);
		Player p4 = new Player(p4Name, controller.tokens[3]);
		controller.players[0] = p1;
		controller.players[1] = p2;
		controller.players[2] = p3;
		controller.players[3] = p4;
	}
	
	private boolean anyFieldNull(MainController controller){
		return controller.getMenu().txtFieldPlayer1.getText().isEmpty() || controller.getMenu().txtFieldPlayer2.getText().isEmpty() 
					|| controller.getMenu().txtFieldPlayer3.getText().isEmpty() || controller.getMenu().txtFieldPlayer4.getText().isEmpty() ;
	}
	
	private boolean sameNickName(MainController controller){
		return (controller.getMenu().txtFieldPlayer1.getText()).equals(controller.getMenu().txtFieldPlayer2.getText())
			||(controller.getMenu().txtFieldPlayer1.getText()).equals(controller.getMenu().txtFieldPlayer3.getText())
			||(controller.getMenu().txtFieldPlayer1.getText()).equals(controller.getMenu().txtFieldPlayer4.getText())
			||(controller.getMenu().txtFieldPlayer2.getText()).equals(controller.getMenu().txtFieldPlayer3.getText())
			||(controller.getMenu().txtFieldPlayer2.getText()).equals(controller.getMenu().txtFieldPlayer4.getText())
			||(controller.getMenu().txtFieldPlayer3.getText()).equals(controller.getMenu().txtFieldPlayer4.getText());
			}
	
	private void initTokens(MainController controller){
		Token token1 = new Token("Car");
		Token token2 = new Token("Laptop");
		Token token3 = new Token("Phone");
		Token token4 = new Token("Mouse");
		controller.tokens[0] = token1;
		controller.tokens[1] = token2;
		controller.tokens[2] = token3;
		controller.tokens[3] = token4;
	}
	
	public void howToPlay(MainController controller){
		JOptionPane.showMessageDialog(null, "Roll Dice \n" + "Move \n" + "Buy Property \n" + "Sell Property \n" + "Repeat"  );
	}
	
	public void exit(MainController controller){
		System.exit(0);
	}
	
}

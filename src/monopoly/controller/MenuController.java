package monopoly.controller;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import monopoly.gamepanel.Map;
import monopoly.main.Main;
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
			Main.frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			int width = Main.frame.getWidth();
			int height = Main.frame.getHeight();
			controller.map = new Map(height, controller);
			controller.setView(controller.map, width, height);
			initComponents(controller);
			setTurnLimit(controller);
			System.out.println(controller.numberOfTurns);
		}
	}
	
	private void setTurnLimit(MainController controller){
		JComboBox<Integer> comboBox = controller.getMenu().comboBox;
		int turn = (int) comboBox.getSelectedItem();
		controller.numberOfTurns = turn;
	}
	
	private void initComponents(MainController controller){
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

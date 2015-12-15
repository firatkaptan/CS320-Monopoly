package monopoly.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import monopoly.gamepanel.InformationPanel;
import monopoly.gamepanel.MainMenu;
import monopoly.gamepanel.MainPanel;
import monopoly.gamepanel.PlayerPanel;
import monopoly.model.GoToJail;
import monopoly.model.Jail;
import monopoly.model.Map;
import monopoly.model.ParkingLot;
import monopoly.model.Player;
import monopoly.model.Property;
import monopoly.model.Square;
import monopoly.model.Token;

public class Controller implements MouseListener {
	Map map;
	InformationPanel info;
	MainMenu menu;
	MainPanel mainPanel;
	PlayerPanel playerPanel;
	int doubleCount;
	Player owner;
	int newPosition;
	Square[] squareArray;
	public Player[] players;
	public Token[] tokens;
	public int turnNumber;
	int taxes;
	Random rn = new Random();
	public Player currentPlayer;

	public Controller(MainMenu menu, MainPanel mainPanel) {
		this.mainPanel = mainPanel;
		this.menu = menu;
		menu.btnStart.addMouseListener(this);
		menu.btnExit.addMouseListener(this);
	}

	private boolean anyFieldNull() {
		return menu.txtFieldPlayer1.getText().isEmpty() || menu.txtFieldPlayer2.getText().isEmpty()
				|| menu.txtFieldPlayer3.getText().isEmpty() || menu.txtFieldPlayer4.getText().isEmpty();
	}

	private boolean sameNickName() {
		return (menu.txtFieldPlayer1.getText()).equals(menu.txtFieldPlayer2.getText())
				|| (menu.txtFieldPlayer1.getText()).equals(menu.txtFieldPlayer3.getText())
				|| (menu.txtFieldPlayer1.getText()).equals(menu.txtFieldPlayer4.getText())
				|| (menu.txtFieldPlayer2.getText()).equals(menu.txtFieldPlayer3.getText())
				|| (menu.txtFieldPlayer2.getText()).equals(menu.txtFieldPlayer4.getText())
				|| (menu.txtFieldPlayer3.getText()).equals(menu.txtFieldPlayer4.getText());
	}

	@Override
	public void mouseClicked(MouseEvent e) {


	}
	public boolean hasAllColor(int i,Square[] s){
		if(i==s.length){
			return true;
		}else if(s[i].getSquareType()=='p'){
			if(((Property) s[i]).hasOwner()&&!((Property) s[i]).getOwner().getName().equals(currentPlayer.getName()) && s[i].color==s[newPosition].color){
				return false;
			}
		}
		return hasAllColor(i+1,s);
	}
	void endTurn() {
		turnNumber+=1;
		currentPlayer = players[(turnNumber-1)%4];
		info.setTurn(turnNumber);
		info.setCurrentPlayer(currentPlayer.getName());
		for(int i=0;i<doubleCount+1;i++){
			map.roll.removeMouseListener(this);
		}
		doubleCount=0;
		map.buy.setEnabled(false);
		map.sell.setEnabled(false);
		map.payOut.setEnabled(false);
		map.buy.removeMouseListener(this);
		map.sell.removeMouseListener(this);
		map.payOut.removeMouseListener(this);
	}

	void addMouseListeners() {
		for (int i = 0; i < map.squareArray.length; i++) {
			map.squareArray[i].addMouseListener(this);
		}
		map.roll.addMouseListener(this);
	}

	void rollDice() {
		int d1 = rn.nextInt(5)+1;
		int d2 = rn.nextInt(5)+1;
		int position = currentPlayer.token.getPosition();
		System.out.println(currentPlayer.getName() + " has rolled : " + d1 + " + " + d2);
		map.d1.setDice(d1);
		map.d2.setDice(d2);
		newPosition = (position + d1 + d2) % 28;
		if (d1 == d2) {
			currentPlayer.jailed = false;
			doubleCount+=1;
			move();
			map.roll.addMouseListener(this);
			map.roll.setEnabled(true);
		}else if(!currentPlayer.isInJail()){
			if (position + d1 + d2 >= 28) {
				currentPlayer.addMoney(20000);
			}
			doubleCount = 0;
			
			move();

		}else{
			map.payOut.setEnabled(true);
			map.payOut.addMouseListener(this);
			
		}
		checkSquare();
	} 







	private void checkSquare() {
		if (map.squareArray[newPosition] instanceof Property) {
			info.setCurrentPrice(((Property) map.squareArray[newPosition]).getPrice());
			if (((Property) map.squareArray[newPosition]).hasOwner()) {
				owner = ((Property) map.squareArray[newPosition]).getOwner();
				info.setOwnerName(owner.getName());
				info.lblOwner.setVisible(true);
				if (currentPlayer.properties.contains((Property) map.squareArray[newPosition])) {
					map.sell.setEnabled(true);
					map.sell.addMouseListener(this);
				} else {
					int rent = ((Property) map.squareArray[newPosition]).getRent();
					rent *= ((Property) map.squareArray[newPosition]).buildings + 1;
					currentPlayer.spendMoney(rent);
					owner.addMoney(rent);
				}

			} else {
				info.lblOwner.setVisible(false);
				map.buy.setEnabled(true);
				map.buy.addMouseListener(this);
			}
			info.lblCurrentPrice.setVisible(true);
		} else {
			info.lblCurrentPrice.setVisible(false);
			info.lblOwner.setVisible(false);
			if (map.squareArray[newPosition] instanceof GoToJail) {
				goToJail();
			} else if (map.squareArray[newPosition] instanceof ParkingLot) {
				collectTax();
			} else if (map.squareArray[newPosition] instanceof Jail) {
				endTurn();
			}
		}
	}

	private void collectTax() {
		currentPlayer.addMoney(taxes);
		taxes = 0;
		playerPanel.update(players);
	}

	private void goToJail() {
		currentPlayer.jailed = true;
		newPosition = 21;
		currentPlayer.token.setPosition(newPosition);
		currentPlayer.token.move(map.squareArray[newPosition]);
		doubleCount = 0;
		endTurn();

	}

	public void payOut() {
		map.payOut.setEnabled(false);
		map.payOut.removeMouseListener(this);
		currentPlayer.spendMoney(5000);
		taxes += 5000;
		currentPlayer.jailed = false;
		playerPanel.update(players);
	}

	void move() {
		if(newPosition==21||doubleCount==3){
			goToJail();
			doubleCount=0;
		}else{
			currentPlayer.token.setPosition(newPosition);
			currentPlayer.token.move(map.squareArray[newPosition]);
			info.setCurrentName(map.squareArray[newPosition].name);
		}


	}

	private void buy() {
		currentPlayer.buy((Property) map.squareArray[newPosition]);
		((Property) map.squareArray[newPosition]).setOwner(currentPlayer);
		playerPanel.update(players);
		info.setOwnerName(currentPlayer.getName());
		info.lblOwner.setVisible(true);
		map.sell.addMouseListener(this);
		map.sell.setEnabled(true);
		map.buy.removeMouseListener(this);
		map.buy.setEnabled(false);
	}

	private void sell() {
		currentPlayer.sell((Property) map.squareArray[newPosition]);
		((Property) map.squareArray[newPosition]).setOwner(null);
		info.lblOwner.setVisible(false);
		playerPanel.update(players);
		map.sell.removeMouseListener(this);
		map.sell.setEnabled(false);
		map.buy.addMouseListener(this);
		map.buy.setEnabled(true);
	}

	private void addPlayers() {
		tokens = new Token[4];
		tokens[0] = (new Token((Color) menu.comboBox1.getSelectedItem(), mainPanel.y * 7 / 8, 0));
		tokens[1] = (new Token((Color) menu.comboBox2.getSelectedItem(), mainPanel.y * 7 / 8, 1));
		tokens[2] = (new Token((Color) menu.comboBox3.getSelectedItem(), mainPanel.y * 7 / 8, 2));
		tokens[3] = (new Token((Color) menu.comboBox4.getSelectedItem(), mainPanel.y * 7 / 8, 3));
		players = new Player[4];
		players[0] = new Player(menu.txtFieldPlayer1.getText(), tokens[0], 0);
		players[1] = new Player(menu.txtFieldPlayer2.getText(), tokens[1], 1);
		players[2] = new Player(menu.txtFieldPlayer3.getText(), tokens[2], 2);
		players[3] = new Player(menu.txtFieldPlayer4.getText(), tokens[3], 3);
		tokens[0].setPlayer(players[0]);
		tokens[1].setPlayer(players[1]);
		tokens[2].setPlayer(players[2]);
		tokens[3].setPlayer(players[3]);
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		if (event.getSource() instanceof Property) {
			mainPanel.mousePanel.update((Property) event.getSource());
		}
	}

	@Override
	public void mouseExited(MouseEvent event) {
		if (event.getSource() instanceof Property) {
			mainPanel.mousePanel.empty();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (mainPanel.gameStatus) {
			if (e.getSource() == map.roll) {
				map.roll.setEnabled(false);
				for(int i=0;i<doubleCount+1;i++){
					map.roll.removeMouseListener(this);
				}
				
				
				rollDice();

				map.endTurn.addMouseListener(this);
				map.endTurn.setEnabled(true);

				playerPanel.update(players);

			} else if (e.getSource() == map.endTurn) {
				map.endTurn.removeMouseListener(this);
				map.endTurn.setEnabled(false);

				endTurn();

				map.roll.addMouseListener(this);
				map.roll.setEnabled(true);

				playerPanel.update(players);
			} else if (e.getSource() == map.buy) {
				buy();
			} else if (e.getSource() == map.sell) {
				sell();
			} else if (e.getSource() == map.payOut) {
				payOut();
			}
		} else  {
			if ((JButton) e.getSource() == menu.btnStart) {
				if (!sameNickName() && !anyFieldNull()) {
					setupGame();
				} else if (anyFieldNull()) {
					JOptionPane.showMessageDialog(null, "Please fill all of the player names !");
				} else if (sameNickName()) {
					JOptionPane.showMessageDialog(null, "Select different Nick Names for each player!");
				}
			} else if (e.getSource() == menu.btnExit) {
				System.exit(0);
			}

		}
	}

	public void setupGame() {
		addPlayers();
		mainPanel.gameScreen(players, tokens);
		map = mainPanel.map;
		info = mainPanel.info;
		playerPanel = mainPanel.playerPanel;
		addMouseListeners();
		turnNumber = 1;
		currentPlayer = players[0];
		info.setCurrentPlayer(players[0].getName());
		info.setTurn(turnNumber);
		info.setTurnLimit((int) menu.comboBox.getSelectedItem());
		info.setCurrentName(map.squareArray[0].name);
		doubleCount = 0;
		taxes = 0;
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}

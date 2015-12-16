package monopoly.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import monopoly.gamepanel.HowToPlayScreen;
import monopoly.gamepanel.InformationPanel;
import monopoly.gamepanel.MainMenu;
import monopoly.gamepanel.MainPanel;
import monopoly.gamepanel.PlayerPanel;
import monopoly.model.Chance;
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
	int turnLimit;
	public boolean isRollable,isEndable,isBuyable,isBuildable,isSellable;

	public Controller(MainMenu menu, MainPanel mainPanel) {
		this.mainPanel = mainPanel;
		this.menu = menu;
		menu.btnStart.addMouseListener(this);
		menu.btnExit.addMouseListener(this);
		menu.btnHowToPlay.addMouseListener(this);
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (mainPanel.gameStatus) {
			if (e.getSource() == map.roll&&isRollable) {
				isRollable=false;
				isEndable=true;
				map.roll.setEnabled(false);
				map.endTurn.setEnabled(true);
				rollDice();
				playerPanel.update(players);
			} else if (e.getSource() == map.endTurn&&isEndable) {
				
				endTurn();
				playerPanel.update(players);
			} else if (e.getSource() == map.buy&&isBuyable) {
				buy();
			} else if (e.getSource() == map.sell&&isSellable) {
				sell();
			} else if (e.getSource() == map.payOut&&currentPlayer.isInJail()) {
				payOut();
			} else if(e.getSource()==map.build&&isBuildable){
				build();
			}
		} else {
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
			}else if(e.getSource()==menu.btnHowToPlay){
				mainPanel.howToPlay();
				mainPanel.howTo.back.addMouseListener(this);
			}else if(e.getSource()==mainPanel.howTo.back){
				mainPanel.backToMenu();
			}

		}
	}
	
	void endTurn() {
		checkWinner();
		turnNumber += 1;
		currentPlayer = players[(turnNumber-1)%4];
		info.setTurn(turnNumber);
		info.setCurrentPlayer(currentPlayer.getName());
		doubleCount = 0;
		isRollable=true;
		map.roll.setEnabled(true);
		isEndable=false;
		map.endTurn.setEnabled(false);
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
			moveDouble();
			isRollable=true;
			map.roll.setEnabled(true);
			map.endTurn.setEnabled(false);
			isEndable=false;
		} else if (!currentPlayer.isInJail()) {
			if (position + d1 + d2 >= 28) {
				currentPlayer.addMoney(20000);
			}
			doubleCount = 0;

			move();
			
		} else {
			isRollable=false;
		}
		
		
	}
	private void build(){
		if(((Property) map.squareArray[newPosition]).isOwner(currentPlayer)){
			((Property) map.squareArray[newPosition]).build(1);
			currentPlayer.spendMoney(((Property) map.squareArray[newPosition]).getCost());
		}
		playerPanel.update(players);
		checkSquare();
	}

	private void checkSquare() {
		isSellable=false;
		isBuildable=false;
		isBuyable=false;
		map.buy.setEnabled(false);
		map.sell.setEnabled(false);
		map.build.setEnabled(false);
		if (map.squareArray[newPosition] instanceof Property) {
			
			info.setCurrentPrice(((Property) map.squareArray[newPosition]).getPrice());
			if (((Property) map.squareArray[newPosition]).hasOwner()) {
				owner = ((Property) map.squareArray[newPosition]).getOwner();
				info.setOwnerName(owner.getName());
				info.lblOwner.setVisible(true);
				if (((Property) map.squareArray[newPosition]).isOwner(currentPlayer)) {
					isSellable=true;
					map.sell.setEnabled(true);
					if (hasAllColor(map.squareArray)&&((Property) map.squareArray[newPosition]).getBuildings()<4) {
						isBuildable=true;
						map.build.setEnabled(true);
					}
				} else {
					int rent = ((Property) map.squareArray[newPosition]).getRent();
					rent *= ((Property) map.squareArray[newPosition]).buildings + 1;
					currentPlayer.spendMoney(rent);
					owner.addMoney(rent);
					}
			} else {
				isBuyable=true;
				map.buy.setEnabled(true);
				info.lblOwner.setVisible(false);
				
			}
			info.lblCurrentPrice.setVisible(true);
		} else {
			info.lblCurrentPrice.setVisible(false);
			info.lblOwner.setVisible(false);
			isBuyable=false;
			isSellable=false;
			if (map.squareArray[newPosition] instanceof GoToJail) {
				goToJail();
			} else if (map.squareArray[newPosition] instanceof ParkingLot) {
				collectTax();
			} else if (map.squareArray[newPosition] instanceof Jail) {
				endTurn();
			} else if (map.squareArray[newPosition] instanceof Chance) {
				newPosition = (newPosition + 10) % 28;
				move();
			}
		}
	}
	void moveDouble(){
		currentPlayer.jailed = false;
		move();
		doubleCount += 1;		
	}
	void move() {
		
		if (newPosition == 14 || doubleCount == 3) {
			goToJail();
			doubleCount = 0;
		} else {
			currentPlayer.token.setPosition(newPosition);
			currentPlayer.token.move(map.squareArray[newPosition]);
			info.setCurrentName(map.squareArray[newPosition].name);
		}
		checkSquare();
	}
	
	private void buy() {
		currentPlayer.buy((Property) map.squareArray[newPosition]);
		((Property) map.squareArray[newPosition]).setOwner(currentPlayer);
		playerPanel.update(players);
		checkSquare();
		
	}
	
	private void sell() {
		currentPlayer.sell((Property) map.squareArray[newPosition]);
		((Property) map.squareArray[newPosition]).setOwner(null);
		playerPanel.update(players);
		checkSquare();
	}
	
	public void payOut() {
		currentPlayer.spendMoney(5000);
		taxes += 5000;
		currentPlayer.jailed = false;
		playerPanel.update(players);
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
		System.out.println(currentPlayer.getName()+"is in Jail");
		endTurn();
	}
	public Player winner() {
		Player winner = players[0];
		for (int i = 0; i < players.length; i++) {
			if (players[i].getScore() > winner.getScore()) {
				winner = players[i];
			}
		}
		return winner;
	}
	public boolean hasAllColor(Square[] s) {
		int i=newPosition;
		Player p=currentPlayer;
		if(i==1||i==2){
			return ((Property) s[1]).isOwner(p)&&((Property) s[2]).isOwner(p);
		}else if(i==4||i==5||i==6) {
			return ((Property) s[4]).isOwner(p)&&((Property) s[5]).isOwner(p)&&((Property) s[6]).isOwner(p);
		}else if(i==8||i==9||i==10) {
			return ((Property) s[8]).isOwner(p)&&((Property) s[9]).isOwner(p)&&((Property) s[10]).isOwner(p);
		}else if(i==12||i==13) {
			return ((Property) s[12]).isOwner(p)&&((Property) s[13]).isOwner(p);
		}else if(i==17||i==15||i==16) {
			return ((Property) s[17]).isOwner(p)&&((Property) s[15]).isOwner(p)&&((Property) s[16]).isOwner(p);
		}else if(i==19||i==20) {
			return ((Property) s[19]).isOwner(p)&&((Property) s[20]).isOwner(p);
		}else if(i==27||i==25||i==26) {
			return ((Property) s[27]).isOwner(p)&&((Property) s[25]).isOwner(p)&&((Property) s[26]).isOwner(p);
		}else if(i==22||i==23) {
			return ((Property) s[22]).isOwner(p)&&((Property) s[23]).isOwner(p);
		}else{
			return false;
		}
		
	}
	void checkWinner(){
		if (turnNumber >= turnLimit) {
			JOptionPane.showMessageDialog(null, "The Game has reached end, The Winner is : " + winner().getName());
			System.exit(0);
		}else if(currentPlayer.getMoney()<=0){
			JOptionPane.showMessageDialog(null, "Player : "+currentPlayer.getName()+" has bakrupted, The Winner is : " + winner().getName());
			System.exit(0);
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
		turnLimit = (int) menu.comboBox.getSelectedItem();
		info.setTurnLimit(turnLimit);
		info.setCurrentName(map.squareArray[0].name);
		doubleCount = 0;
		taxes = 0;
		isRollable=true;
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
	
	void addMouseListeners() {
		for (int i = 0; i < map.squareArray.length; i++) {
			map.squareArray[i].addMouseListener(this);
		}
		map.roll.addMouseListener(this);
		map.endTurn.addMouseListener(this);
		map.buy.addMouseListener(this);
		map.sell.addMouseListener(this);
		map.payOut.addMouseListener(this);
		map.build.addMouseListener(this);
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
	public void mouseReleased(MouseEvent e) {

	}
	@Override
	public void mouseClicked(MouseEvent e) {

	}
}
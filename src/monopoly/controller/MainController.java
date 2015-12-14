package monopoly.controller;
import java.awt.Container;

import monopoly.gamepanel.Map;
import monopoly.gamepanel.Menu;
import monopoly.gamepanel.Monopoly;
import monopoly.main.Main;
import monopoly.model.Dice;
import monopoly.model.Player;
import monopoly.model.Token;

public class MainController {

	public int currentTurn;
	public int numberOfTurns;
	
	public Player[] players;
	public Token[] tokens;

	public Dice dice1;
	public Dice dice2;
	
	private Player currentPlayer;
	private Menu menu;

	public Map map;
	public Monopoly monopoly;
	
	public MenuController menuController;
	public MonopolyController monopolyController;
	
	
	public MainController(){
		menuController = new MenuController();
		monopolyController = new MonopolyController();
		menu = new Menu(this);
	}
	
	public void setView(Object view, int width, int height){
		Main.frame.setContentPane((Container) view);
		Main.frame.pack();
		Main.frame.setSize(width, height);
	}
	
	public Menu getMenu(){
		return menu;
	}
	
	public Player getCurrentPlayer(){
		return currentPlayer;
	}
	
	public void setCurrentPlayer(Player p){
		currentPlayer = p;
	}
}

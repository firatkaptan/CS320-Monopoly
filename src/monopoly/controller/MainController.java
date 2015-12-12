package monopoly.controller;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import monopoly.gamepanel.Map;
import monopoly.gamepanel.Menu;
import monopoly.main.Main;
import monopoly.model.Player;

public class MainController {

	private int currentTurn;
	public int numberOfTurns;
	
	private Player currentPlayer;
	private Menu menu;
	public Map map;
	
	public MenuController menuController;
	
	
	public MainController(){
		menuController = new MenuController();
		menu = new Menu(this);
		setTurnLimit();
	}
	
	private void setTurnLimit() {
		JComboBox<Integer> comboBox = this.menu.comboBox;
		int turn = (int) comboBox.getSelectedItem();
		numberOfTurns = turn;
	}
	
	public void setView(Object view, int width, int height){
		Main.frame.setContentPane((Container) view);
		Main.frame.pack();
		Main.frame.setSize(width, height);
		System.out.println("Intent has changed");
	}
	
	public Menu getMenu(){
		return menu;
	}
	
	public Map getMap(){
		return map;
	}
	
	public Player getCurrentPlayer(){
		return currentPlayer;
	}
}

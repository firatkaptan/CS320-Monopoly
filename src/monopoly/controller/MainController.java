package monopoly.controller;
import java.awt.Container;
import javax.swing.JComboBox;
import monopoly.gamepanel.Map;
import monopoly.gamepanel.Menu;
import monopoly.main.Main;
import monopoly.model.Player;
import monopoly.model.Token;

public class MainController {

	private int currentTurn;
	public int numberOfTurns;
	
	public Player[] players;
	public Token[] tokens;
	
	private Player currentPlayer;
	private Menu menu;
	public Map map;
	
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

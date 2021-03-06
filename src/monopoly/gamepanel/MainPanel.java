package monopoly.gamepanel;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import monopoly.controller.Controller;
import monopoly.model.Map;
import monopoly.model.Player;
import monopoly.model.Token;

public class MainPanel extends JFrame{
	int x;
	public int y;
	public MainMenu menu;
	public Map map;
	public InformationPanel info;
	public PlayerPanel playerPanel;
	public MouseInfoPanel mousePanel;
	public HowToPlayScreen howTo;
	Controller controller;
	public Boolean gameStatus;
	public MainPanel(){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		x=dim.width;
		y=dim.height;
		setLayout(null);
		setTitle("Welcome to MonoPoly game!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startScreen();
		
		
		
		
	}
	public void startScreen(){
		setSize(x/4+10,y/2+40);
		menu=new MainMenu(x,y);
		gameStatus=false;
		add(menu);
		controller=new Controller(menu,this);
		setVisible(true);
	}
	public void gameScreen(Player[] players,Token[] tokens){
		remove(menu);
		setSize(x,y);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		map=new Map(y*7/8,players,tokens);
		info=new InformationPanel(x,y);
		playerPanel=new PlayerPanel(x,y,players);
		mousePanel=new MouseInfoPanel(x,y);
		
		add(map);
		add(info);
		add(playerPanel);
		add(mousePanel);
		gameStatus=true;
	}
	public void howToPlay(){
		remove(menu);
		setSize(x/4+10,y/2+40);
		howTo=new HowToPlayScreen(x,y);
		gameStatus=false;
		add(howTo);
		repaint();
	}
	public void backToMenu(){
		remove(howTo);
		startScreen();
		repaint();
	}
	
}

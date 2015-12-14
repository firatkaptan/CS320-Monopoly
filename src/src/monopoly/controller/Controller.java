package monopoly.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;

import monopoly.gamepanel.InformationPanel;
import monopoly.gamepanel.MainMenu;
import monopoly.gamepanel.MainPanel;
import monopoly.model.Map;
import monopoly.model.Player;
import monopoly.model.Square;
import monopoly.model.Start;
import monopoly.model.Token;

public class Controller implements MouseListener{
	Map map;
	InformationPanel info;
	MainMenu menu;
	MainPanel mainPanel;
	public Player[] players;
	public Token[] tokens;
	Random rn = new Random();
	public Controller(Map map,MainMenu menu,MainPanel mainPanel,InformationPanel info){
		this.map=map;
		this.info=info;
		this.mainPanel=mainPanel;
		this.menu=menu;
		menu.btnStart.addMouseListener(this);
		menu.btnExit.addMouseListener(this);
	}
	private boolean anyFieldNull(){
		return menu.txtFieldPlayer1.getText().isEmpty() || menu.txtFieldPlayer2.getText().isEmpty() 
				|| menu.txtFieldPlayer3.getText().isEmpty() || menu.txtFieldPlayer4.getText().isEmpty() ;
	}

	private boolean sameNickName(){
		return (menu.txtFieldPlayer1.getText()).equals(menu.txtFieldPlayer2.getText())
				||(menu.txtFieldPlayer1.getText()).equals(menu.txtFieldPlayer3.getText())
				||(menu.txtFieldPlayer1.getText()).equals(menu.txtFieldPlayer4.getText())
				||(menu.txtFieldPlayer2.getText()).equals(menu.txtFieldPlayer3.getText())
				||(menu.txtFieldPlayer2.getText()).equals(menu.txtFieldPlayer4.getText())
				||(menu.txtFieldPlayer3.getText()).equals(menu.txtFieldPlayer4.getText());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(!mainPanel.gameStatus){
			if((JButton) e.getSource()==menu.btnStart){
				if(!sameNickName()&&!anyFieldNull()){
					addPlayers();
					mainPanel.gameScreen(players,tokens);
					mainPanel.info.setCurrentPlayer(players[0].getName());
					mainPanel.info.setTurn(1);
					mainPanel.info.setTurnLimit((int) menu.comboBox.getSelectedItem());
					map=mainPanel.map;
					map.roll.addMouseListener(this);
				}
			}else if(e.getSource()==menu.btnExit){
				System.exit(0);
			}

		}else if(mainPanel.gameStatus){
			if(e.getSource()==map.roll){
				int d1=rn.nextInt(5)+1;
				int d2=rn.nextInt(5)+1;
				map.d1.setDice(d1);
				map.d2.setDice(d2);
				int position=players[0].token.getPosition();
				players[0].token.setPosition((position+d1+d2)%28);
				players[0].token.move(map.squareArray[(position+d1+d2)%28]);
			}
		}

	}

	private void addPlayers() {
		tokens=new Token[4];
		tokens[0]=(new Token((Color) menu.comboBox1.getSelectedItem(),mainPanel.y*7/8,0));
		tokens[1]=(new Token((Color) menu.comboBox2.getSelectedItem(),mainPanel.y*7/8,1));
		tokens[2]=(new Token((Color) menu.comboBox3.getSelectedItem(),mainPanel.y*7/8,2));
		tokens[3]=(new Token((Color) menu.comboBox4.getSelectedItem() ,mainPanel.y*7/8,3));
		players=new Player[4];
		players[0]=new Player(menu.txtFieldPlayer1.getText(),tokens[0],0);
		players[1]=new Player(menu.txtFieldPlayer2.getText(),tokens[1],1);
		players[2]=new Player(menu.txtFieldPlayer3.getText(),tokens[2],2);
		players[3]=new Player(menu.txtFieldPlayer4.getText(),tokens[3],3);
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}

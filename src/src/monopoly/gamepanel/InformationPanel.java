package monopoly.gamepanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InformationPanel extends JPanel{
	public JLabel lblCurrentPlayer,lblCurrentTurn,lblTurnLimit,lblCurrentPlayer2,lblCurrentTurn2,lblTurnLimit2,lblCurrentPlayer3,lblCurrentTurn3,lblTurnLimit3;
	int x,y;
	public InformationPanel(int x,int y){
		this.x=x;
		this.y=y;
		setLayout(new GridLayout(5, 3));	
		setBounds(y*7/8, 0, x-y, y/4);
		setVisible(true);
		
		lblCurrentPlayer=new JLabel("s");
		lblCurrentTurn=new JLabel("f");
		lblTurnLimit =new JLabel("a");
		lblCurrentPlayer2=new JLabel("s2");
		lblCurrentTurn2=new JLabel("f2");
		lblTurnLimit2 =new JLabel("a2");
		lblCurrentPlayer3=new JLabel("s3");
		lblCurrentTurn3=new JLabel("f3");
		lblTurnLimit3 =new JLabel("a4");
		add(lblTurnLimit);
		add(lblCurrentTurn2);		
		add(lblCurrentPlayer);
		add(lblTurnLimit2);
		add(lblCurrentTurn);
		add(lblCurrentPlayer2);
		add(lblTurnLimit3);
		add(lblCurrentTurn3);
		add(lblCurrentPlayer3);
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		add(lblNewLabel_2);
		
	}
	public void setTurnLimit(int i){
		lblTurnLimit.setText("Number of Turns : " +i);
	}
	public void setTurn(int i){
		lblCurrentTurn.setText("Current Turn : "+i);
	}
	public void setCurrentPlayer(String s){
		lblCurrentPlayer.setText("Current Player : " + s);
	}
}

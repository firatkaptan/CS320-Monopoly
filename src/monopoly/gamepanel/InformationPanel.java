package monopoly.gamepanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class InformationPanel extends JPanel{
	public JLabel lblCurrentPlayer,lblCurrentTurn,lblTurnLimit,lblOwner,lblCurrentLocationName,lblCurrentPrice;
	int x,y;
	public InformationPanel(int x,int y){
		this.x=x;
		this.y=y;
		setLayout(new GridLayout(3, 2));
		setBounds(y*7/8+5, 5, (x-y)/2, 7*y/30-10);
		setBorder(new TitledBorder(null, "Game Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setVisible(true);
		
		lblCurrentPlayer=new JLabel("");
		lblCurrentTurn=new JLabel("");
		lblTurnLimit =new JLabel("");
		lblOwner=new JLabel("");
		lblCurrentLocationName=new JLabel("");
		lblCurrentPrice =new JLabel("");
		
		add(lblTurnLimit);
		add(lblCurrentLocationName);		
		add(lblCurrentPlayer);
		add(lblCurrentPrice);
		add(lblCurrentTurn);
		add(lblOwner);
	}
	public void setCurrentPrice(int a){
		lblCurrentPrice.setText("Price : "+a);
	}
	public void setOwnerName(String s){
		lblOwner.setText("Owner : "+s);
	}
	public void setCurrentName(String s){
		lblCurrentLocationName.setText("Current Location : "+s);
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

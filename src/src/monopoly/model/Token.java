package monopoly.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Token extends JPanel{
	Player player;
	Color color;
	int position;
	Square s;
	int x;
	int playerNumber;
	public Token(Color color,int x,int playerNumber){
		this.color=color;
		this.x=x;
		this.playerNumber=playerNumber;
		setBounds(0,0,x,x);
		setVisible(true);
		setOpaque(false);

	}
	public void setPlayer(Player p){
		player=p;
	}
	public void setPosition(int i){
		position=i;
	}
	public int getPosition(){
		return position;
	}
	public void move(Square square){
		s=square;
		repaint();
	}
	public Square getSquare(){
		return s;
	}
	public Player getPlayer(){
		return player;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(color);
		switch(playerNumber){
		case 0:
			g.fillOval(s.getX()+1, s.getY()+x/24, x/32, x/32);
			g.setColor(color.white);
			g.setFont(new Font("Serif", Font.BOLD, 16));
			g.drawString("1", s.getX()+x/64, s.getY()+x/16);
			break;
		case 1:
			g.fillOval(s.getX()+1+x/32, s.getY()+x/24, x/32, x/32);
			g.setColor(color.white);
			g.setFont(new Font("Serif", Font.BOLD, 16));
			g.drawString("2", s.getX()+3*x/64, s.getY()+x/16);
			break;
		case 2:
			g.fillOval(s.getX()+1+x/16, s.getY()+x/24, x/32, x/32);
			g.setColor(color.white);
			g.setFont(new Font("Serif", Font.BOLD, 16));
			g.drawString("3", s.getX()+5*x/64, s.getY()+x/16);
			break;
		case 3:
			g.fillOval(s.getX()+1+x/16+x/32, s.getY()+x/24, x/32, x/32);
			g.setColor(color.white);
			g.setFont(new Font("Serif", Font.BOLD, 16));
			g.drawString("4", s.getX()+7*x/64, s.getY()+x/16);
			break;
		}		
	}
}

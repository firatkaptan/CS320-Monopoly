package monopoly.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Dice extends JLabel {
	int x;
	int number;
	public Dice(int x,int number) {
		this.number=number;
		this.x=x;
		setSize(x/12,x/12);
		setVisible(true);
	}
	public void setDice(int number){
		this.number=number;
		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, x/12, x/12);
		g.setColor(Color.WHITE);
		switch(number){
		case 1:
			g.fillOval(x/36,x/36,x/36,x/36);
		break;
		case 2:
			g.fillOval(1,1,x/36,x/36);
			g.fillOval(x/18-1,x/18-1,x/36,x/36);
		break;
		case 3:
			g.fillOval(1,1,x/36,x/36);
			g.fillOval(x/18-1,x/18-1,x/36,x/36);
			g.fillOval(x/36,x/36,x/36,x/36);
		break;
		case 4:
			g.fillOval(1,1,x/36,x/36);
			g.fillOval(x/18-1,x/18-1,x/36,x/36);
			g.fillOval(1,x/18-1,x/36,x/36);
			g.fillOval(x/18-1,1,x/36,x/36);
		break;
		case 5:
			g.fillOval(1,1,x/36,x/36);
			g.fillOval(x/18-1,x/18-1,x/36,x/36);
			g.fillOval(1,x/18-1,x/36,x/36);
			g.fillOval(x/18-1,1,x/36,x/36);
			g.fillOval(x/36,x/36,x/36,x/36);
		break;
		case 6:
			g.fillOval(1,1,x/36,x/36-1);
			g.fillOval(x/18-1,x/18-1,x/36,x/36-1);
			g.fillOval(1,x/18-1,x/36,x/36-1);
			g.fillOval(x/18-1,1,x/36,x/36-1);
			g.fillOval(x/18-1,x/36,x/36,x/36-1);
			g.fillOval(1,x/36,x/36,x/36-1);
		break;
	}
	}
}

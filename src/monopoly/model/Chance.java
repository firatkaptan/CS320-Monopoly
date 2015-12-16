package monopoly.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Chance extends Square{
	int x,y;
	public Chance(int x,int y){
		super(x,y,'c',Color.YELLOW,"Chance");
		this.x=x;
		this.y=y;
		setLocation(super.getX(),super.getY());
		setSize(x/8,x/8);
		setVisible(true);
	}
	public void paint(Graphics g){
		g.setColor(color);
		g.fillRect(0, 0, x/8, x/8);
		g.drawRect(0, 1, x/8-1, x/8-2);
		g.setColor(Color.RED);
		g.setFont(new Font("Serif", Font.BOLD, 140));
		g.drawString("$", 22, 100);
		
	}
}

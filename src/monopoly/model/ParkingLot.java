package monopoly.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class ParkingLot extends Square {
	int x,y;
	public ParkingLot(int x,int y){
		super(x,y,'l',Color.RED,"Parking Lot");
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
		g.setColor(new Color(255-color.getRed(),255-color.getGreen(),255-color.getBlue()));
		g.setFont(new Font("Serif", Font.BOLD, x/32));
		g.drawString("Park", x/38, x/32);
		
	}
}

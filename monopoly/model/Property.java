package monopoly.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Property extends Square{
	int price,rent,buildCost,buildings,x,y;
	Player owner;
	Color color;
	
	
	public Property(int x,int y,Color color,String name,int price,int rent,int buildCost){
		super(x,y,'p',color,name);
		this.x=x;
		this.y=y;
		this.price=price;
		this.rent=rent;
		this.buildCost=buildCost;
		this.color=color;
		buildings=0;
		setLocation(x,0);
		setSize(108,108);
		setVisible(true);
		
	}
	void build(int a){
		buildings+=a;
	}
	void setOwner(Player player){
		owner=player;
	}
	public int getCost(){
		return buildCost;
	}
	public int getRent(){
		return rent;
	}
	public int getPrice(){
		return price;
	}
	
	@Override
	public void paint(Graphics g){
		g.setColor(color);
		g.fillRect(0, 0, 108, 40);
		g.setColor(Color.BLACK);
		g.drawString(name, 15, 15);
		
	}

}

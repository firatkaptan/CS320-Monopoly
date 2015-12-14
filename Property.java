package monopoly.model;

import java.awt.Color;
import java.util.ArrayList;

public class Property extends Square{
	int price,rent,buildCost,buildings;
	Player owner;
	
	
	public Property(int x,int y,Color color,String name,int price,int rent,int buildCost){
		super(x,y,'p',color,name);
		this.price=price;
		this.rent=rent;
		this.buildCost=buildCost;
		buildings=0;
		
	}
	void build(int a){
		buildings+=a;
	}
	void setOwner(Player player){
		owner=player;
	}

}

package monopoly.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Property extends Square{
	public int price,rent,buildCost,buildings,x,y;
	public Player owner=null;
	public Color color;
	
	
	public Property(int x,int y,Color color,String name,int price,int rent,int buildCost){
		super(x,y,'p',color,name);
		this.x=x;
		this.y=y;
		this.price=price;
		this.rent=rent;
		this.buildCost=buildCost;
		this.color=color;
		buildings=0;
		setLocation(super.getX(),super.getY());
		setSize(x/8,x/8);
		setVisible(true);
		setBackground(Color.WHITE);
	}
	public void build(int a){
		buildings+=a;
	}
	public int getBuildings(){
		return buildings;
	}
	public void setOwner(Player player){
		owner=player;
	}
	public Player getOwner(){
		return owner;
	}
	public int getCost(){
		return buildCost;
	}
	public int getRent(){
		return rent;
	}
	public boolean isOwner(Player p){
		if(!hasOwner()){
			return false;
		}
			
		else{
			return owner.getName().equals(p.getName());
		}
		
	}
	public int getPrice(){
		return price;
	}
	public boolean hasOwner(){
		if(owner==null){
			return false;
		}else{
			return true;
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(color);
		g.fillRect(0, 0, x/8, x/24);
		g.drawRect(0, 1, x/8-1, x/8-2);
		g.setColor(new Color(255-color.getRed(),255-color.getGreen(),255-color.getBlue()));
		g.setFont(new Font("Serif", Font.BOLD, 12));
		g.drawString(name, x/22-name.length()*3, x/48);
		
	}

}

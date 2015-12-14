package monopoly.model;

import java.awt.Color;

import javax.swing.JPanel;

public class Square{
	int x,y;
	char type;
	Color color;
	String name;
	

	public Square(int x,int y, char type,Color color,String name){
		this.x=x;
		this.y=y;
		this.type=type;
		this.color=color;
		this.name=name;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public char getSquareType(){
		return type;
	}
	public void setX(int a){
		x=a;
	}
	public void setY(int a){
		y=a;
	}
	
	


}

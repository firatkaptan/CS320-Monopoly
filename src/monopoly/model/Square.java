package monopoly.model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class Square extends JPanel{
	int a,b;
	char type;
	public Color color;
	public String name;
	

	public Square(int x,int y,char type,Color color,String name){
		if(y<7){
			this.a=x*y/8;
			this.b=0;
		}else if(y<14){
			this.a=x*7/8;
			this.b=(x*(y%7)/8);
		}else if(y<21){
			this.a=x-(x*(y%13)/8);
			this.b=x*7/8;
		}else if(y<28){
			this.a=0;
			this.b=(x*7/8)-x*(y%21)/8;
		}
		this.type=type;
		this.color=color;
		this.name=name;
	}

	public int getX(){
		return a;
	}
	public int getY(){
		return b;
	}
	public char getSquareType(){
		return type;
	}
	public void setX(int a){
		this.a=a;
	}
	public void setY(int a){
		this.b=a;
	}
	


}

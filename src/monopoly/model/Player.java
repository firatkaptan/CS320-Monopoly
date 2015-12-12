package monopoly.model;

import java.util.ArrayList;

import monopoly.gamepanel.Property;

public class Player {
	int money;
	private String name;
	private Token token;
	ArrayList<Property> properties= new ArrayList<Property>();
	public Player(String name,Token token){
		this.name=name;
		this.token=token;
	}
	
	public int getMoney() {
		return money;
	}
	public String getName(){
		return name;
	}
	public void addMoney(int a){
		money+=a;
	}
	public void spendMoney(int a){
		money-=a;
	}
	public void buy(Property p){
		properties.add(p);
		spendMoney(p.price);
	}
	public void sell(Property p){
		properties.remove(p);
		addMoney(p.price);
	}
	public Token getToken(){
		return token;
	}
}

package monopoly.model;

import java.util.ArrayList;

public class Player {
	int number;
	int money;
	String name;
	public Token token;
	ArrayList<Property> properties= new ArrayList<Property>();
	public Player(String name,Token token,int number){
		this.name=name;
		this.token=token;
		this.number=number;
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
		addMoney(p.price/2);
	}
}

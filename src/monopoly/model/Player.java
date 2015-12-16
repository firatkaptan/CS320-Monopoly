package monopoly.model;

import java.util.ArrayList;

public class Player {
	public int number;
	int money=150000;
	String name;
	public Token token;
	public boolean jailed;
	public ArrayList<Property> properties= new ArrayList<Property>();
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
	public boolean isInJail(){
		return jailed;
	}
	public int getMoney(){
		return money;
	}
	public int getScore(){
		int score=money;
		for(int i=0;i<properties.size();i++){
			score+=properties.get(i).price+(properties.get(i).buildings*properties.get(i).buildCost);
		}
		return score;
	}
	public void sell(Property p){
		properties.remove(p);
		addMoney((p.price/2)+(p.buildings*p.buildCost)/2);
		p.buildings=0;
	}
}

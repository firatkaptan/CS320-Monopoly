import java.util.ArrayList;

public class Player {

	private int money=0;
	private Token token;
	private boolean isPlaying=false;
	private String name="";
	private ArrayList<Property> properties;
	
	
	Player (String name, Token token)
	{
		this.token=token;
		this.name=name;
	}
	
	
	public  int getMoney()
	{
		return money;
	}
	
	public Token getToken()
	{
		return token;
	}
	
	public void setToken(Token token)
	{
		this.token=token;
	}
	
	
	public ArrayList<Property> getProperties()
	{
		return properties;
	}
	
	void addMoney(int amount)
	{
		money+=amount;
	}
	
	
	public int rollDice(Dice dice)
	{
		 dice.roll();
		 return dice.getValue();
	}
	
	
	public String toString()
	{
		return name+" has "+ money;
	}
}

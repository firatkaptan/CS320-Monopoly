import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Property  extends JPanel implements Square{

	private String name;
	private int price;
	private int income;
	private Player owner;
	private BufferedImage Image;
	int width,height;
	
	Property(String name,int price)
	{
		this.name=name;
		this.price=price;
		
	}
	
	@Override
	public int getPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	
	
	public void setOwner(Player p)
	{
		owner=p;
	}

	
	public Player getOwner()
	{
		return owner;
	}
	
	public int getIncome()
	{
		return income;
	}
	
	public void  setIncome(int income)
	{
		this.income=income;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public void setImage(BufferedImage Image)
	{
		this.Image=Image;
	}
	
	protected void paintComponent (Graphics g) 
	{
		g.drawImage(Image, 0, 0, null);
	}
	
	
	
	public String toString()
	{
		return "this"+ name+" is owned by "+owner.toString();
	}
}
